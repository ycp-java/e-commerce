package com.ytc.model;

import java.io.Serializable;

public class Adress implements Serializable {
    private static final long serialVersionUID = 4418191453615829439L;
    private Integer adressid;

    private String adressname;
    private Integer userid;

    @Override
    public String toString() {
        return "Adress{" +
                "adressid=" + adressid +
                ", adressname='" + adressname + '\'' +
                ", userid=" + userid +
                '}';
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getAdressid() {
        return adressid;
    }

    public void setAdressid(Integer adressid) {
        this.adressid = adressid;
    }

    public String getAdressname() {
        return adressname;
    }

    public void setAdressname(String adressname) {
        this.adressname = adressname == null ? null : adressname.trim();
    }
}