/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CommodityServiceImpl
 * Author:   ycp
 * Date:     2020/10/9 10:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ytc.mapper.CommodityMapper;
import com.ytc.mapper.Picture1Mapper;
import com.ytc.mapper.Picture2Mapper;
import com.ytc.mapper.PictureMapper;
import com.ytc.model.Commodity;
import com.ytc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ycp
 * @create 2020/10/9
 * @since 1.0.0
 */
@Service
@Component
public class CommodityServiceImpl implements CommodityService{

    @Autowired
   private CommodityMapper commodityMapper;
    @Resource
    private PictureMapper pictureMapper;
    @Resource
    private Picture1Mapper picture1Mapper;
    @Resource
    private Picture2Mapper picture2Mapper;
    //查询商品详情
    @Override
    public Commodity querycomtest(Integer id) {

        return commodityMapper.querycomtest(id);
    }
    //商品列表查询
    @Override
    public PageUtil<Commodity> querycom(Commodity commodity, PageUtil<Commodity> page) {
        Long count=commodityMapper.querycomcount(commodity);
        page=new PageUtil<Commodity>(page.getCpage(),count,page.getPageSize());
        List<Commodity> list=commodityMapper.qeurycom(commodity,page.getStart(),page.getPageSize());
        page.setList(list);
        return page;
    }

    @Override
    public List<Commodity> selectcom() {

        return commodityMapper.selectcom();
    }

    @Override
    public void updatecom(Integer comid) {
        commodityMapper.updatecom(comid);
    }
    @Override
    public PageUtil<Commodity>  querylistById(Integer merchantid,PageUtil<Commodity> page) {
        long count=commodityMapper.querycomcountbyid(merchantid);
        page=new PageUtil<Commodity>(page.getCpage(),count,page.getPageSize());
        List<Commodity>list=commodityMapper.querylistById(merchantid,page.getStart(),page.getPageSize());
        page.setList(list);
        return page;
    }
    @Override
    public void delsCommodity(String ids) {
        String[] idss = ids.split(",");
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < idss.length; i++) {
            list.add(Integer.parseInt(idss[i].trim()));
        }
        commodityMapper.delsCommodity(list);
    }

    @Override
    public void addCommodity(Commodity commodity) {
        pictureMapper.addpicture(commodity);
        picture1Mapper.addpicture(commodity);
        picture2Mapper.addpicture(commodity);
        commodityMapper.addCommodity(commodity);
    }

}