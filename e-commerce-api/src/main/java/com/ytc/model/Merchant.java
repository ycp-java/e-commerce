package com.ytc.model;

import java.io.Serializable;

public class Merchant implements Serializable {
    private static final long serialVersionUID = -1695965900013359597L;
    private Integer merchantid;

    private String merchantname;

    private String merchantpwd;

    private Integer jurisdictionid;

    private Jurisdiction jurisdiction;

    public Jurisdiction getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(Jurisdiction jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname == null ? null : merchantname.trim();
    }

    public String getMerchantpwd() {
        return merchantpwd;
    }

    public void setMerchantpwd(String merchantpwd) {
        this.merchantpwd = merchantpwd == null ? null : merchantpwd.trim();
    }

    public Integer getJurisdictionid() {
        return jurisdictionid;
    }

    public void setJurisdictionid(Integer jurisdictionid) {
        this.jurisdictionid = jurisdictionid;
    }
}