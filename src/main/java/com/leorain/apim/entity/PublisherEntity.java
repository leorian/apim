package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 项目发布表
 */
public class PublisherEntity  extends BaseEntity{
    /**
     * 发布管理ID
     */
    private long publisherId;

    /**
     * 接口ID
     */
    private long interfaceId;

    /**
     * 环境
     */
    private int environment;

    /**
     * 实际调用地址
     */
    private String interfaceRealAddress;

    /**
     * 组
     */
    private String groupName;

    /**
     * 版本
     */
    private String version;

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }

    public long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(long interfaceId) {
        this.interfaceId = interfaceId;
    }

    public int getEnvironment() {
        return environment;
    }

    public void setEnvironment(int environment) {
        this.environment = environment;
    }

    public String getInterfaceRealAddress() {
        return interfaceRealAddress;
    }

    public void setInterfaceRealAddress(String interfaceRealAddress) {
        this.interfaceRealAddress = interfaceRealAddress;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
