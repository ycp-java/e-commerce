package com.ytc.service;

import com.ytc.model.Commodity;
import com.ytc.util.PageUtil;

import java.util.List;

public interface CommodityService {

    Commodity querycomtest(Integer id);

    PageUtil<Commodity> querycom(Commodity commodity, PageUtil<Commodity> page);

    List<Commodity> selectcom();

    void updatecom(Integer comid);

    PageUtil<Commodity>  querylistById(Integer merchantid,PageUtil<Commodity> page);

    void delsCommodity(String ids);

    void addCommodity(Commodity commodity);
}
