package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 接口入参表
 */
public class InterfaceRequestEntity extends BaseEntity{

    /**
     * 接口入参ID
     */
    private long interfaceRequestId;

    /**
     * 接口ID
     */
    private long interfaceId;

    /**
     * 入参位置
     */
    private int location;

    /**
     * 入参名称
     */
    private String requestParameterName;

    /**
     * 入参类型
     */
    private String requestParameterType;

    /**
     * 是否必填
     */
    private int parameterRequired;

    /**
     * 参数说明
     */
    private String parameterDescribe;

    public long getInterfaceRequestId() {
        return interfaceRequestId;
    }

    public void setInterfaceRequestId(long interfaceRequestId) {
        this.interfaceRequestId = interfaceRequestId;
    }

    public long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(long interfaceId) {
        this.interfaceId = interfaceId;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getRequestParameterName() {
        return requestParameterName;
    }

    public void setRequestParameterName(String requestParameterName) {
        this.requestParameterName = requestParameterName;
    }

    public String getRequestParameterType() {
        return requestParameterType;
    }

    public void setRequestParameterType(String requestParameterType) {
        this.requestParameterType = requestParameterType;
    }

    public int getParameterRequired() {
        return parameterRequired;
    }

    public void setParameterRequired(int parameterRequired) {
        this.parameterRequired = parameterRequired;
    }

    public String getParameterDescribe() {
        return parameterDescribe;
    }

    public void setParameterDescribe(String parameterDescribe) {
        this.parameterDescribe = parameterDescribe;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
