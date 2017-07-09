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
    private String projectIdText;

    private String env;
    private String ip;
    private Integer port;
    private String path;

    private String loginAccount;
    private String loginPassword;
    private Integer loginPort;
    private String loginProtocol;
    private String loginOs;

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

    public String getProjectIdText() {
        return projectIdText;
    }

    public void setProjectIdText(String projectIdText) {
        this.projectIdText = projectIdText;
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

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public Integer getLoginPort() {
        return loginPort;
    }

    public void setLoginPort(Integer loginPort) {
        this.loginPort = loginPort;
    }

    public String getLoginProtocol() {
        return loginProtocol;
    }

    public void setLoginProtocol(String loginProtocol) {
        this.loginProtocol = loginProtocol;
    }

    public String getLoginOs() {
        return loginOs;
    }

    public void setLoginOs(String loginOs) {
        this.loginOs = loginOs;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
