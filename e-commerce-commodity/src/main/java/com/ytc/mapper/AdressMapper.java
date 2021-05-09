package com.ytc.mapper;

import com.ytc.model.Adress;

import java.util.List;

public interface AdressMapper {

    List<Adress> selectadr(Integer userid);
}