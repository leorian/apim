package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 接口方法表
 */
public class InterfaceMethodEntity implements Serializable {
    /**
     * 接口方法ID
     */
    private long interfaceMethodId;

    /**
     * 接口ID
     */
    private long interfaceId;

    /**
     * 接口方法名称
     */
    private String interfaceMethodName;

    /**
     * 功能说明
     */
    private String functionDescribe;

    /**
     * 方法参数
     */
    private String methodParameter;

    /**
     * 返回值类型
     */
    private String returnType;

    public long getInterfaceMethodId() {
        return interfaceMethodId;
    }

    public void setInterfaceMethodId(long interfaceMethodId) {
        this.interfaceMethodId = interfaceMethodId;
    }

    public long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(long interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getInterfaceMethodName() {
        return interfaceMethodName;
    }

    public void setInterfaceMethodName(String interfaceMethodName) {
        this.interfaceMethodName = interfaceMethodName;
    }

    public String getFunctionDescribe() {
        return functionDescribe;
    }

    public void setFunctionDescribe(String functionDescribe) {
        this.functionDescribe = functionDescribe;
    }

    public String getMethodParameter() {
        return methodParameter;
    }

    public void setMethodParameter(String methodParameter) {
        this.methodParameter = methodParameter;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
