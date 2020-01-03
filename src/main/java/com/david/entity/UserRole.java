package com.david.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UserRole implements Serializable {
    private Integer urId;

    private Integer uId;

    private Integer rId;

    private static final long serialVersionUID = 1L;

    public Integer getUrId() {
        return urId;
    }

    public void setUrId(Integer urId) {
        this.urId = urId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }
}