package com.leorain.apim.entity;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */

import com.alibaba.fastjson.JSON;


/**
 * 项目接口表
 */
public class InterfaceEntity extends BaseEntity{
    //接口ID
    private Long interfaceId;

    //项目ID
    private Long projectId;

    //项目名称
    private String interfaceName;

    //接口类型
    private Integer interfaceType;

    //接口地址
    private String interfaceAddress;

    //请求方式
    private Integer requestMethod;

    public InterfaceEntity(Long interfaceId, Long projectId, String interfaceName,
                           Integer interfaceType, String interfaceAddress, Integer requestMethod) {
        this.interfaceId = interfaceId;
        this.projectId = projectId;
        this.interfaceName = interfaceName;
        this.interfaceType = interfaceType;
        this.interfaceAddress = interfaceAddress;
        this.requestMethod = requestMethod;
    }

    public Long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Long interfaceId) {
        this.interfaceId = interfaceId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public Integer getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(Integer interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getInterfaceAddress() {
        return interfaceAddress;
    }

    public void setInterfaceAddress(String interfaceAddress) {
        this.interfaceAddress = interfaceAddress;
    }

    public Integer getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(Integer requestMethod) {
        this.requestMethod = requestMethod;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
