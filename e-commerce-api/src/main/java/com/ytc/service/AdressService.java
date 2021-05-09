package com.ytc.service;

import com.ytc.model.Adress;

import java.util.List;

public interface AdressService {
    List<Adress> selectadr(Integer userid);
}
