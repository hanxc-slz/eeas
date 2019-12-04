package com.imnu.eeas.pojo;

import java.util.Date;

public class EnergyYear {
    private Integer id;

    private Integer uId;

    private Double countMonYear;

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

    public Double getCountMonYear() {
        return countMonYear;
    }

    public void setCountMonYear(Double countMonYear) {
        this.countMonYear = countMonYear;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}