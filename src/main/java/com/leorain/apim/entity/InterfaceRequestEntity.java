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
    private Long interfaceRequestId;

    /**
     * 接口ID
     */
    private Long interfaceId;

    /**
     * 入参位置
     */
    private Integer location;

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
    private Integer parameterRequired;

    /**
     * 参数说明
     */
    private String parameterDescribe;

    public Long getInterfaceRequestId() {
        return interfaceRequestId;
    }

    public void setInterfaceRequestId(Long interfaceRequestId) {
        this.interfaceRequestId = interfaceRequestId;
    }

    public Long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Long interfaceId) {
        this.interfaceId = interfaceId;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
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

    public Integer getParameterRequired() {
        return parameterRequired;
    }

    public void setParameterRequired(Integer parameterRequired) {
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
