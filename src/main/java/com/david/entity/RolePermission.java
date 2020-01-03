package com.david.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class RolePermission implements Serializable {
    private Integer rpId;

    private Integer rId;

    private Integer pId;

    private static final long serialVersionUID = 1L;

    public Integer getRpId() {
        return rpId;
    }

    public void setRpId(Integer rpId) {
        this.rpId = rpId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }
}