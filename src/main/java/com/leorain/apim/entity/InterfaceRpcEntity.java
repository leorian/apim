package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezhonggui on 2017/7/15.
 */
public class InterfaceRpcEntity extends BaseEntity {


    public InterfaceRpcEntity() {
    }

    public InterfaceRpcEntity(Long id, Long appId, String name, String className, String methodName,
                              String functionDescribe, String returnType, String methodParam) {
        this.id = id;
        this.appId = appId;
        this.name = name;
        this.className = className;
        this.methodName = methodName;
        this.functionDescribe = functionDescribe;
        this.returnType = returnType;
        this.methodParam = methodParam;
    }

    /**
     * 接口ID
     */
    private Long id;

    /**
     * 应用ID
     */
    private Long appId;

    /**
     * 接口名称
     */
    private String name;

    /**
     * 类全路径名称
     */
    private String className;

    /**
     * 方法名称
     */
    private String methodName;
    /**
     * 功能描述
     */
    private String functionDescribe;

    /**
     * 返回值类型
     */
    private String returnType;

    /**
     * 方法参数
     */
    private String methodParam;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getFunctionDescribe() {
        return functionDescribe;
    }

    public void setFunctionDescribe(String functionDescribe) {
        this.functionDescribe = functionDescribe;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getMethodParam() {
        return methodParam;
    }

    public void setMethodParam(String methodParam) {
        this.methodParam = methodParam;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
