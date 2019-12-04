package com.imnu.eeas.pojo;

import java.util.Date;

public class EnergyMon {
    private Integer id;

    private Integer uId;

    private Double countMon;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Double getCountMon() {
        return countMon;
    }

    public void setCountMon(Double countMon) {
        this.countMon = countMon;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}