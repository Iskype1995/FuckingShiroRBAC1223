package com.david.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Permission implements Serializable {
    private Integer pId;

    private String pName;

    private String pAction;

    private String pInfo;

    private static final long serialVersionUID = 1L;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getpAction() {
        return pAction;
    }

    public void setpAction(String pAction) {
        this.pAction = pAction == null ? null : pAction.trim();
    }

    public String getpInfo() {
        return pInfo;
    }

    public void setpInfo(String pInfo) {
        this.pInfo = pInfo == null ? null : pInfo.trim();
    }
}