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
    private long returnTypeId;

    /**
     * 接口方法ID
     */
    private long interfaceMethodId;

    /**
     * 方法ID
     */
    private long methodId;

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

    public long getReturnTypeId() {
        return returnTypeId;
    }

    public void setReturnTypeId(long returnTypeId) {
        this.returnTypeId = returnTypeId;
    }

    public long getInterfaceMethodId() {
        return interfaceMethodId;
    }

    public void setInterfaceMethodId(long interfaceMethodId) {
        this.interfaceMethodId = interfaceMethodId;
    }

    public long getMethodId() {
        return methodId;
    }

    public void setMethodId(long methodId) {
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
