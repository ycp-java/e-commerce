/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: trolley
 * Author:   ycp
 * Date:     2020/10/10 21:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.model;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ycp
 * @create 2020/10/10
 * @since 1.0.0
 */
public class Trolley implements Serializable {

    private static final long serialVersionUID = 4897534904028777476L;
    private Integer buynum;
    private String comname;
    private Integer comid;
    private Double comprice;
    private Double totleprice;
    private String imgurl;

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Double getTotleprice() {
        return totleprice;
    }

    public void setTotleprice(Double totleprice) {
        this.totleprice = totleprice;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public Integer getBuynum() {
        return buynum;
    }

    public void setBuynum(Integer buynum) {
        this.buynum = buynum;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public Double getComprice() {
        return comprice;
    }

    public void setComprice(Double comprice) {
        this.comprice = comprice;
    }

    public Trolley() {
    }

    @Override
    public String toString() {
        return "Trolley{" +
                "buynum=" + buynum +
                ", comname='" + comname + '\'' +
                ", comid=" + comid +
                ", comprice=" + comprice +
                ", totleprice=" + totleprice +
                '}';
    }
}