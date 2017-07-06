package com.leorain.apim.domain;

import com.alibaba.fastjson.JSON;
import com.leorain.apim.entity.ApiUserEntity;
import org.springframework.util.DigestUtils;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiezg@317hu.com on 2017/7/6 0006.
 */
public class ApiUserDomain {
    private String usNameInput;
    private String cnNameInput;
    private String userRoleInput;
    private String cellPhoneInput;
    private String emailInput;

    public String getUsNameInput() {
        return usNameInput;
    }

    public void setUsNameInput(String usNameInput) {
        this.usNameInput = usNameInput;
    }

    public String getCnNameInput() {
        return cnNameInput;
    }

    public void setCnNameInput(String cnNameInput) {
        this.cnNameInput = cnNameInput;
    }

    public String getUserRoleInput() {
        return userRoleInput;
    }

    public void setUserRoleInput(String userRoleInput) {
        this.userRoleInput = userRoleInput;
    }

    public String getCellPhoneInput() {
        return cellPhoneInput;
    }

    public void setCellPhoneInput(String cellPhoneInput) {
        this.cellPhoneInput = cellPhoneInput;
    }

    public String getEmailInput() {
        return emailInput;
    }

    public void setEmailInput(String emailInput) {
        this.emailInput = emailInput;
    }

    public ApiUserEntity buildApiUserEntity() {
        ApiUserEntity apiUserEntity = new ApiUserEntity();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        apiUserEntity.setUserId(Long.parseLong(simpleDateFormat.format(date)));
        apiUserEntity.setUsName(this.getUsNameInput());
        apiUserEntity.setCnName(this.getCnNameInput());
        apiUserEntity.setUserRole(Integer.parseInt(this.getUserRoleInput()));
        apiUserEntity.setCellPhone(this.getCellPhoneInput());
        apiUserEntity.setEmail(this.getEmailInput());
        apiUserEntity.setCreateDateTime(date);
        apiUserEntity.setUpdateDateTime(date);
        apiUserEntity.setPassword(DigestUtils.md5DigestAsHex("000000".getBytes(Charset.forName("utf-8"))));
        return apiUserEntity;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
