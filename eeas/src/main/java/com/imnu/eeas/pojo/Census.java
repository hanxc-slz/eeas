package com.imnu.eeas.pojo;

import java.util.Date;

public class Census {
    private Integer id;

    private Integer uId;

    private Double countAll;

    private Date frontDate;

    private Date afterDate;

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

    public Double getCountAll() {
        return countAll;
    }

    public void setCountAll(Double countAll) {
        this.countAll = countAll;
    }

    public Date getFrontDate() {
        return frontDate;
    }

    public void setFrontDate(Date frontDate) {
        this.frontDate = frontDate;
    }

    public Date getAfterDate() {
        return afterDate;
    }

    public void setAfterDate(Date afterDate) {
        this.afterDate = afterDate;
    }
}