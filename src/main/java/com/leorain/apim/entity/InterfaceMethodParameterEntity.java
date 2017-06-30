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
    private Long parameterId;

    /**
     * 接口方法ID
     */
    private Long interfaceMethodId;

    /**
     * 方法ID
     */
    private Long methodId;

    /**
     * 参数索引
     */
    private Integer parameterIndex;

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
    private Integer parameterRequired;

    /**
     * 源代码
     */
    private String code;

    public InterfaceMethodParameterEntity(Long parameterId, Long interfaceMethodId, Long methodId,
                                          Integer parameterIndex, String parameterTypeShortName, String parameterTypeFullName,
                                          String parameterName, String parameterMeaning, Integer parameterRequired, String code) {
        this.parameterId = parameterId;
        this.interfaceMethodId = interfaceMethodId;
        this.methodId = methodId;
        this.parameterIndex = parameterIndex;
        this.parameterTypeShortName = parameterTypeShortName;
        this.parameterTypeFullName = parameterTypeFullName;
        this.parameterName = parameterName;
        this.parameterMeaning = parameterMeaning;
        this.parameterRequired = parameterRequired;
        this.code = code;
    }

    public Long getParameterId() {
        return parameterId;
    }

    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
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

    public Integer getParameterIndex() {
        return parameterIndex;
    }

    public void setParameterIndex(Integer parameterIndex) {
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

    public Integer getParameterRequired() {
        return parameterRequired;
    }

    public void setParameterRequired(Integer parameterRequired) {
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
