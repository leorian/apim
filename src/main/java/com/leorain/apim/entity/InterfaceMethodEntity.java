package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;


/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 接口方法表
 */
public class InterfaceMethodEntity extends BaseEntity {
    /**
     * 接口方法ID
     */
    private Long interfaceMethodId;

    /**
     * 接口ID
     */
    private Long interfaceId;

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

    public InterfaceMethodEntity(Long interfaceMethodId, Long interfaceId, String interfaceMethodName,
                                 String functionDescribe, String methodParameter, String returnType) {
        this.interfaceMethodId = interfaceMethodId;
        this.interfaceId = interfaceId;
        this.interfaceMethodName = interfaceMethodName;
        this.functionDescribe = functionDescribe;
        this.methodParameter = methodParameter;
        this.returnType = returnType;
    }

    public Long getInterfaceMethodId() {
        return interfaceMethodId;
    }

    public void setInterfaceMethodId(Long interfaceMethodId) {
        this.interfaceMethodId = interfaceMethodId;
    }

    public Long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Long interfaceId) {
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
