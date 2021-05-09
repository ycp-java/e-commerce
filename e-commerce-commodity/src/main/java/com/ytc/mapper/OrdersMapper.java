package com.ytc.mapper;

import com.ytc.model.Merchant;
import com.ytc.model.Orders;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {

    void insertorder(@Param("o") Orders orders);
    

    long ordercount(Integer userid);

    List<Orders> orderlist(@Param("id") Integer userid, @Param("start")int start, @Param("pagesize")int pageSize);
    //修改订单状态

    void zhifu(String orderid);

    List<Orders> querylistorder(Integer merchantid);
}