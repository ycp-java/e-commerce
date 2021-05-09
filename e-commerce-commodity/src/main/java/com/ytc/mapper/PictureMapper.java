package com.ytc.mapper;

import com.ytc.model.Commodity;
import com.ytc.model.Picture;
import org.apache.ibatis.annotations.Param;

public interface PictureMapper {

    void addpicture(@Param("c") Commodity commodity);
}