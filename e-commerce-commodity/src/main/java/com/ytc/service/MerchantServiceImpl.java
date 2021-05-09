package com.ytc.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ytc.mapper.MerchantMapper;
import com.ytc.model.Merchant;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Service
@Component
public class MerchantServiceImpl implements MerchantService {
    @Resource
    private MerchantMapper merchantMapper;

    @Override
    public Merchant queryMerchantByName(Merchant merchant) {
        return merchantMapper.queryUserByName(merchant);
    }

    @Override
    public void register(Merchant merchant) {
        merchantMapper.register(merchant);
    }
}
