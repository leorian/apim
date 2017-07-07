package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/7/7 0007.
 * 项目部署情况表
 */
public class ProjectDeployEntity extends BaseEntity {
    private Long deployId;
    private String deployIdText;

    private Long projectId;
    private String env;
    private String ip;
    private Integer port;
    private String path;

    public ProjectDeployEntity() {
    }

    public ProjectDeployEntity(Long deployId, Long projectId, String env, String ip, Integer port, String path) {
        this.deployId = deployId;
        this.projectId = projectId;
        this.env = env;
        this.ip = ip;
        this.port = port;
        this.path = path;
    }

    public Long getDeployId() {
        return deployId;
    }

    public void setDeployId(Long deployId) {
        this.deployId = deployId;
    }

    public String getDeployIdText() {
        return deployIdText;
    }

    public void setDeployIdText(String deployIdText) {
        this.deployIdText = deployIdText;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
