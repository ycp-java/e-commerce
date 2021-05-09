/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: trolleyController
 * Author:   ycp
 * Date:     2020/10/8 19:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ytc.model.*;
import com.ytc.service.AdressService;
import com.ytc.service.CommodityService;
import com.ytc.service.OrdersService;
import com.ytc.uitl.RandomIDUtil;
import com.ytc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ycp
 * @create 2020/10/8
 * @since 1.0.0
 */
@Controller
@RequestMapping("/trolley")
public class trolleyController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Reference
    private CommodityService commodityService;

    @Reference
    private OrdersService ordersService;
    @Reference
    private AdressService adressService;

    @RequestMapping("totrolley")
    public String totrolley(Model m,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        m.addAttribute("username",user.getUsername());
        return "trolleyshow";
    }


   @RequestMapping("querycomtest")
    public String querycomtest (Model m,Integer id,HttpServletRequest request){

      //  Integer userid=1;
       Commodity com =commodityService.querycomtest(id);

       //request.getSession().setAttribute("userid",userid);

       m.addAttribute("list",com);

       return "showtest";
   }
   //把购物车信息存到redis中
   @RequestMapping("inserttrolley")
   @ResponseBody
    public void inserttrolley(HttpServletRequest request,Integer buynum,Double comprice,String comname,Integer comid,String imgurl){
       HttpSession session = request.getSession();
        //假设用户id
       User user = (User) session.getAttribute("user");
       Integer userid = user.getUserid();
       //定义key
       String str="user"+userid.toString();
       //创建购物车对象
       Trolley tro=new Trolley();
        tro.setComprice(comprice);
        tro.setComname(comname);
        tro.setComid(comid);
        tro.setBuynum(buynum);
        tro.setImgurl(imgurl);
        double a=tro.getBuynum()*tro.getComprice();
        tro.setTotleprice(a);
        //如果存在相同商品，增加数量
       if(redisTemplate.hasKey(str)) {
           Map<Object, Object> m = redisTemplate.opsForHash().entries(str);
           Set<Map.Entry<Object, Object>> entries = m.entrySet();
           Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
           //循环map集合
           while (iterator.hasNext()) {
               Map.Entry<Object, Object> en = iterator.next();
               //判断是否已经购买商品
               //拿到redis中的购物车集合
               if (en.getKey().equals(comid.toString())) {
                   Trolley value = (Trolley) en.getValue();
                   if (value.getComid().equals(comid)) {
                           tro.setBuynum(value.getBuynum() + buynum);
                           tro.setTotleprice(tro.getBuynum()*tro.getComprice());
                           Map<String,Trolley> map=new HashMap<String, Trolley>();
                           map.put(comid.toString(),tro);
                           redisTemplate.opsForHash().putAll(str,map);
                       }
               }
               else{
                   Map<String,Trolley> map=new HashMap<String, Trolley>();
                   map.put(comid.toString(),tro);
                   redisTemplate.opsForHash().putAll(str,map);
               }
           }
       }
        //不存在相同商品，新增购物车
       else{
       //判断购物车是否为空，如果为空新增购物车
               Map<String,Trolley> map=new HashMap<String, Trolley>();
               map.put(comid.toString(),tro);
               redisTemplate.opsForHash().putAll(str,map);
       }
   }
   //查询购物车
    @RequestMapping("SelectTrolley")
    public String SelectTrolley(Model m, PageUtil<Trolley> page, HttpServletRequest request){
       //从作用域里拿到userid
        User user = (User) request.getSession().getAttribute("user");
        Integer userid = user.getUserid();
        List<Adress> adrlist=adressService.selectadr(userid);
        //定义key
        String str="user"+userid.toString();
        List<Trolley> trolist=new ArrayList<Trolley>();
        if(redisTemplate.hasKey(str)){
            Map<Object, Object> entries = redisTemplate.opsForHash().entries(str);
            Set<Map.Entry<Object, Object>> entries1 = entries.entrySet();
            Iterator<Map.Entry<Object, Object>> iterator = entries1.iterator();
            Trolley t = new Trolley();
            while (iterator.hasNext()){
                Map.Entry<Object, Object> en = iterator.next();
                trolist.add((Trolley) en.getValue());
            }
        }
        page=new PageUtil<Trolley>(page.getCpage(), (long) trolist.size(),page.getPageSize());
        List<Trolley> list1=new ArrayList<>();
        for (int i=page.getStart();i<page.getEnd();i++)
        {
            if(i<trolist.size()){
                list1.add(trolist.get(i));
            }
        }
        page.setList(list1);
        request.getSession().setAttribute("page",page);
        m.addAttribute("username",user.getUsername());
        m.addAttribute("adr",adrlist);
        m.addAttribute("page",page);
        return "trolleylist";
    }
    //批量删除
    @RequestMapping("deltrolley")
    @ResponseBody
    public void deltrolley(String ids,Double toprice,Integer adress, HttpServletRequest request){
        PageUtil page = (PageUtil) request.getSession().getAttribute("page");
        List<Trolley> comlist = page.getList();
        User user = (User) request.getSession().getAttribute("user");
        Integer userid = user.getUserid();
        String str="user"+userid;
        String[] id = ids.split(",");
        Orders orders=new Orders();
        for(int i=0;i<id.length;i++){
            //获得购买的商品
            if(comlist.get(i).getComid().toString().equals(id[i].trim())){
                String danhao = danhao(userid);
                orders.setCommodityid(comlist.get(i).getComid());
                orders.setUserid(userid);
                orders.setTotulprice(toprice);
                orders.setCreateTime(new Date().toLocaleString());
                orders.setOrderid(danhao);
                orders.setStatus(0);
                orders.setAdressid(adress);
                ordersService.insertorder(orders);
                //删除redis中商品
               redisTemplate.opsForHash().delete(str,id[i].trim());
               commodityService.updatecom(comlist.get(i).getComid());
            }
        }

    }
    //生成订单号
    public String danhao(Integer userid){
        RandomIDUtil randomIDUtil=new RandomIDUtil();
        Long l = randomIDUtil.nextId();
        String s=userid.toString()+ l.toString();
        return s;
    }
//跳转订单页面
    @RequestMapping("toordershow")
    public String toordershow(){
        return "toordershow";
    }
//展示订单列表
    @RequestMapping("orderlist")
    public String orderlist(HttpServletRequest request,Model m,PageUtil<Orders> page){
        User user = (User) request.getSession().getAttribute("user");
        Integer userid = user.getUserid();
        page=ordersService.orderlist(userid,page);
        m.addAttribute("page",page);
        return "orderlist";
    }
    @RequestMapping("zhifu")
    @ResponseBody
    public void zhifu(String orderid){
        ordersService.zhifu(orderid);
    }

}