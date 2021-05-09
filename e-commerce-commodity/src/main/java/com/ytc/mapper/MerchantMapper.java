package com.ytc.mapper;

import com.ytc.model.Merchant;
import org.apache.ibatis.annotations.Param;

public interface MerchantMapper {

    Merchant queryUserByName(Merchant merchant);

    void register(@Param("merchant")Merchant merchant);
}