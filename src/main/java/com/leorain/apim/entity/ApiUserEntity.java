package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;
import com.leorain.apim.enums.UserRoleEnum;


/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 用户表
 */
public class ApiUserEntity extends BaseEntity {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户ID纯文本，防止long类型精度丢失
     */
    private String userIdText;

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
    private Integer userRole;

    /**
     * 用户身份转换后的值
     */
    private String userRoleText;

    /**
     * 手机号码
     */
    private String cellPhone;

    /**
     * 工作邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    public ApiUserEntity() {
    }

    public ApiUserEntity(Long userId, String usName, String cnName, Integer userRole, String cellPhone, String email, String password) {
        this.userId = userId;
        this.usName = usName;
        this.cnName = cnName;
        this.userRole = userRole;
        this.cellPhone = cellPhone;
        this.email = email;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserIdText() {
        return userIdText;
    }

    public void setUserIdText(String userIdText) {
        this.userIdText = userIdText;
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

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRoleText() {
        return UserRoleEnum.DATA_MAP.get(this.getUserRole());
    }

    public void setUserRoleText(String userRoleText) {
        this.userRoleText = userRoleText;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
