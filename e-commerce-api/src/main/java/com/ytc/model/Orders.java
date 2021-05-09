package com.ytc.model;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {
    private static final long serialVersionUID = -607476880015938139L;
    private String orderid;

    private Integer userid;

    private String createTime;

    private Integer status;

    private Double totulprice;

    private Integer commodityid;

    private Commodity commodity;

    private User user;
    private Integer adressid;
    private Adress adress;
    private Merchant merchant;
    @Override
    public String toString() {
        return "Orders{" +
                "orderid='" + orderid + '\'' +
                ", userid=" + userid +
                ", createTime='" + createTime + '\'' +
                ", status=" + status +
                ", totulprice=" + totulprice +
                ", commodityid=" + commodityid +
                ", commodity=" + commodity +
                ", user=" + user +
                ", adressid=" + adressid +
                ", adress=" + adress +
                '}';
    }

    public Double getTotulprice() {
        return totulprice;
    }

    public void setTotulprice(Double totulprice) {
        this.totulprice = totulprice;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Integer getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Integer commodityid) {
        this.commodityid = commodityid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}