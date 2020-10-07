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
import com.ytc.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ecommerce")
public class EcommerceController {
@Reference
    private CommodityService commodityService;
@Reference
    private JurisdictionService jurisdictionService;
@Reference
    private UserService userService;
@Reference
    private PictureService pictureService;
@Reference
    private Picture1Service pictureService1;
@Reference
    private Picture2Service pictureService2;
@Reference
    private TypeService typeService;
@Reference
    private OrderService orderService;

}