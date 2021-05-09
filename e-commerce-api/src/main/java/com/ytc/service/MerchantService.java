package com.ytc.service;

import com.ytc.model.Merchant;


public interface MerchantService {
    Merchant queryMerchantByName(Merchant merchant);

    void register(Merchant merchant);
}
