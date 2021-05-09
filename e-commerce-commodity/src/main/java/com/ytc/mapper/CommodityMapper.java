package com.ytc.mapper;

import com.ytc.model.Commodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityMapper {

    //查询单件商品详情
    Commodity querycomtest(Integer id);
    //查询商品数量
    Long querycomcount(@Param("c")Commodity commodity);
    //条件,分页查询全部商品
    List<Commodity> qeurycom(@Param("c")Commodity commodity,@Param("start")int start,@Param("pagesize")int pageSize);

    List<Commodity> selectcom();

    void updatecom(Integer comid);

    long querycomcountbyid(Integer merchantid);

    List<Commodity> querylistById(@Param("id") Integer merchantid, @Param("start")int start, @Param("pagesize")int pageSize);

    void delsCommodity(List<Integer> list);

    void addCommodity(@Param("c") Commodity commodity);
}
