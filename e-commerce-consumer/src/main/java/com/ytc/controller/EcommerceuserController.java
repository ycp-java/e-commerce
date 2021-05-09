/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: EcommerceController
 * Author:   ycp
 * Date:     2020/10/7 14:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ytc.model.Commodity;
import com.ytc.model.Type;
import com.ytc.service.*;

import com.ytc.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/user")
public class EcommerceuserController {
    @Reference
    private CommodityService commodityService;
    @Reference
    private TypeService typeService;
//跳前台展示--跳转show页面
    @RequestMapping("tocomshow")
    public String tocomshow(Model m){
        List<Type> list=typeService.selecttype();
        m.addAttribute("typee",list);
        return "tocomshow";
    }
//前台展示--跳list页面
    @RequestMapping("comshow")
    public String comshow(Model m, Commodity commodity, PageUtil<Commodity> page){
        page=commodityService.querycom(commodity,page);
        m.addAttribute("page",page);
        return "comshow";
    }
    //后台展示
    @RequestMapping("showbymer")
    public String showbymer(){

        return "showbymer";
    }
}