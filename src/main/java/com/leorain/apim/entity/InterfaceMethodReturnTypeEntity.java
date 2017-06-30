package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 接口方法返回值类型表
 */
public class InterfaceMethodReturnTypeEntity extends BaseEntity{
    /**
     * 返回值类型ID
     */
    private Long returnTypeId;

    /**
     * 接口方法ID
     */
    private Long interfaceMethodId;

    /**
     * 方法ID
     */
    private Long methodId;

    /**
     * 返回值类型简称
     */
    private String returnTypeShortName;

    /**
     * 返回值类型全称
     */
    private String returnTypeFullName;

    /**
     * 源代码
     */
    private String code;

    public InterfaceMethodReturnTypeEntity(Long returnTypeId, Long interfaceMethodId, Long methodId,
                                           String returnTypeShortName, String returnTypeFullName, String code) {
        this.returnTypeId = returnTypeId;
        this.interfaceMethodId = interfaceMethodId;
        this.methodId = methodId;
        this.returnTypeShortName = returnTypeShortName;
        this.returnTypeFullName = returnTypeFullName;
        this.code = code;
    }

    public Long getReturnTypeId() {
        return returnTypeId;
    }

    public void setReturnTypeId(Long returnTypeId) {
        this.returnTypeId = returnTypeId;
    }

    public Long getInterfaceMethodId() {
        return interfaceMethodId;
    }

    public void setInterfaceMethodId(Long interfaceMethodId) {
        this.interfaceMethodId = interfaceMethodId;
    }

    public Long getMethodId() {
        return methodId;
    }

    public void setMethodId(Long methodId) {
        this.methodId = methodId;
    }

    public String getReturnTypeShortName() {
        return returnTypeShortName;
    }

    public void setReturnTypeShortName(String returnTypeShortName) {
        this.returnTypeShortName = returnTypeShortName;
    }

    public String getReturnTypeFullName() {
        return returnTypeFullName;
    }

    public void setReturnTypeFullName(String returnTypeFullName) {
        this.returnTypeFullName = returnTypeFullName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
