package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/7/11 0011.
 */
public class InterfaceHttpEntity extends BaseEntity {
    public InterfaceHttpEntity() {
    }

    public InterfaceHttpEntity(Long id, Long appId, String protocol, String method, String transformat,
                               String address, String name, String description) {
        this.id = id;
        this.appId = appId;
        this.protocol = protocol;
        this.method = method;
        this.transformat = transformat;
        this.address = address;
        this.name = name;
        this.description = description;
    }

    /**
     * 接口ID主键
     */
    private Long id;

    /**
     * 项目ID/应用ID
     */
    private Long appId;

    /**
     * 请求协议
     */
    private String protocol;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 传输格式
     */
    private String transformat;

    /**
     * 接口地址
     */
    private String address;

    /**
     * 接口名称
     */
    private String name;

    /**
     * 接口描述
     */
    private String description;

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

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTransformat() {
        return transformat;
    }

    public void setTransformat(String transformat) {
        this.transformat = transformat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
