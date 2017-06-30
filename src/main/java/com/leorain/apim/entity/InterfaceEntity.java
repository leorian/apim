package com.leorain.apim.entity;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 项目接口表
 */
public class InterfaceEntity implements Serializable{
    //接口ID
    private long interfaceId;

    //项目ID
    private long projectId;

    //项目名称
    private String interfaceName;

    //接口类型
    private int interfaceType;

    //接口地址
    private String interfaceAddress;

    //请求方式
    private int requestMethod;

    public long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(long interfaceId) {
        this.interfaceId = interfaceId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public int getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(int interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getInterfaceAddress() {
        return interfaceAddress;
    }

    public void setInterfaceAddress(String interfaceAddress) {
        this.interfaceAddress = interfaceAddress;
    }

    public int getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(int requestMethod) {
        this.requestMethod = requestMethod;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
