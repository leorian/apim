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
    private Long publisherId;

    /**
     * 接口ID
     */
    private Long interfaceId;

    /**
     * 环境
     */
    private Integer environment;

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

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public Long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Long interfaceId) {
        this.interfaceId = interfaceId;
    }

    public Integer getEnvironment() {
        return environment;
    }

    public void setEnvironment(Integer environment) {
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
