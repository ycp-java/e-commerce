package com.ytc.mapper;

import com.ytc.model.Commodity;
import com.ytc.model.Picture1;
import org.apache.ibatis.annotations.Param;

public interface Picture1Mapper {


    void addpicture(@Param("c")Commodity commodity);
}