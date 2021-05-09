/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: OrdersServiceImpl
 * Author:   ycp
 * Date:     2020/10/15 10:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ytc.mapper.OrdersMapper;
import com.ytc.model.Merchant;
import com.ytc.model.Orders;
import com.ytc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ycp
 * @create 2020/10/15
 * @since 1.0.0
 */
@Service
@Component
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public void insertorder(Orders orders) {
        ordersMapper.insertorder(orders);

    }

    @Override
    public PageUtil orderlist(Integer userid, PageUtil<Orders> page) {
        long count =ordersMapper.ordercount(userid);
        page=new PageUtil<Orders>(page.getCpage(),count,page.getPageSize());
        List<Orders> list=ordersMapper.orderlist(userid,page.getStart(),page.getPageSize());
        page.setList(list);
        return page;
    }

    @Override
    public void zhifu(String orderid) {
        ordersMapper.zhifu(orderid);
    }

    @Override
    public List<Orders> querylistorder(Integer merchantid) {
        return ordersMapper.querylistorder(merchantid);
    }
}