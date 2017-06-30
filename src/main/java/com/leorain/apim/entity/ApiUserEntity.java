package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 用户表
 */
public class ApiUserEntity {
    /**
     * 用户ID
     */
    private long userId;

    /**
     * 英文名称
     */
    private String usName;

    /**
     * 中文名称
     */
    private String cnName;

    /**
     * 用户身份
     */
    private int userRole;

    /**
     * 手机号码
     */
    private String cellPhone;

    /**
     * 工作邮箱
     */
    private String email;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsName() {
        return usName;
    }

    public void setUsName(String usName) {
        this.usName = usName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
