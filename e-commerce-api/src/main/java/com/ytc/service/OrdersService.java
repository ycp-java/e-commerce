package com.ytc.service;

import com.ytc.model.Merchant;
import com.ytc.model.Orders;
import com.ytc.util.PageUtil;

import java.util.List;

public interface OrdersService {
    void insertorder(Orders orders);

    PageUtil<Orders> orderlist(Integer userid, PageUtil<Orders> page);

    void zhifu(String orderid);

    List<Orders> querylistorder(Integer merchantid);
}
