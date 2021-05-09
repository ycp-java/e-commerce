package com.ytc.mapper;

import com.ytc.model.Commodity;
import com.ytc.model.Picture2;
import org.apache.ibatis.annotations.Param;

public interface Picture2Mapper {

    void addpicture(@Param("c") Commodity commodity);
}