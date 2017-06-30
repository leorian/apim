package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 接口方法参数表
 */
public class InterfaceMethodParameterEntity extends  BaseEntity{
    /**
     * 参数ID
     */
    private long parameterId;

    /**
     * 接口方法ID
     */
    private long interfaceMethodId;

    /**
     * 方法ID
     */
    private long methodId;

    /**
     * 参数索引
     */
    private int parameterIndex;

    /**
     * 参数类型简称
     */
    private String parameterTypeShortName;

    /**
     * 参数类型全称
     */
    private String parameterTypeFullName;

    /**
     * 参数名称
     */
    private String parameterName;

    /**
     * 参数意义
     */
    private String parameterMeaning;

    /**
     * 参数必填
     */
    private int parameterRequired;

    /**
     * 源代码
     */
    private String code;

    public long getParameterId() {
        return parameterId;
    }

    public void setParameterId(long parameterId) {
        this.parameterId = parameterId;
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

    public int getParameterIndex() {
        return parameterIndex;
    }

    public void setParameterIndex(int parameterIndex) {
        this.parameterIndex = parameterIndex;
    }

    public String getParameterTypeShortName() {
        return parameterTypeShortName;
    }

    public void setParameterTypeShortName(String parameterTypeShortName) {
        this.parameterTypeShortName = parameterTypeShortName;
    }

    public String getParameterTypeFullName() {
        return parameterTypeFullName;
    }

    public void setParameterTypeFullName(String parameterTypeFullName) {
        this.parameterTypeFullName = parameterTypeFullName;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterMeaning() {
        return parameterMeaning;
    }

    public void setParameterMeaning(String parameterMeaning) {
        this.parameterMeaning = parameterMeaning;
    }

    public int getParameterRequired() {
        return parameterRequired;
    }

    public void setParameterRequired(int parameterRequired) {
        this.parameterRequired = parameterRequired;
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
