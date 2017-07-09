package com.leorain.apim.domain;

import com.alibaba.fastjson.JSON;
import com.leorain.apim.entity.ProjectDeployEntity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiezg@317hu.com on 2017/7/7 0007.
 */
public class ProjectDeployDomain implements Serializable {
    private String projectIdInput;
    private String envInput;
    private String ipInput;
    private String portInput;
    private String pathInput;
    private String loginOsInput;
    private String loginProtocolInput;
    private String loginPortInput;
    private String loginAccountInput;
    private String loginPasswordInput;

    public String getProjectIdInput() {
        return projectIdInput;
    }

    public void setProjectIdInput(String projectIdInput) {
        this.projectIdInput = projectIdInput;
    }

    public String getEnvInput() {
        return envInput;
    }

    public void setEnvInput(String envInput) {
        this.envInput = envInput;
    }

    public String getIpInput() {
        return ipInput;
    }

    public void setIpInput(String ipInput) {
        this.ipInput = ipInput;
    }

    public String getPortInput() {
        return portInput;
    }

    public void setPortInput(String portInput) {
        this.portInput = portInput;
    }

    public String getPathInput() {
        return pathInput;
    }

    public void setPathInput(String pathInput) {
        this.pathInput = pathInput;
    }

    public String getLoginOsInput() {
        return loginOsInput;
    }

    public void setLoginOsInput(String loginOsInput) {
        this.loginOsInput = loginOsInput;
    }

    public String getLoginProtocolInput() {
        return loginProtocolInput;
    }

    public void setLoginProtocolInput(String loginProtocolInput) {
        this.loginProtocolInput = loginProtocolInput;
    }

    public String getLoginPortInput() {
        return loginPortInput;
    }

    public void setLoginPortInput(String loginPortInput) {
        this.loginPortInput = loginPortInput;
    }

    public String getLoginAccountInput() {
        return loginAccountInput;
    }

    public void setLoginAccountInput(String loginAccountInput) {
        this.loginAccountInput = loginAccountInput;
    }

    public String getLoginPasswordInput() {
        return loginPasswordInput;
    }

    public void setLoginPasswordInput(String loginPasswordInput) {
        this.loginPasswordInput = loginPasswordInput;
    }

    public ProjectDeployEntity buildProjectDeployEntity() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        ProjectDeployEntity projectDeployEntity = new ProjectDeployEntity();
        projectDeployEntity.setDeployId(Long.valueOf(simpleDateFormat.format(date)));
        projectDeployEntity.setProjectId(Long.valueOf(this.getProjectIdInput()));
        projectDeployEntity.setEnv(this.getEnvInput());
        projectDeployEntity.setIp(this.getIpInput());
        projectDeployEntity.setPort(Integer.valueOf(this.getPortInput()));
        projectDeployEntity.setPath(this.getPathInput());
        projectDeployEntity.setLoginOs(this.getLoginOsInput());
        projectDeployEntity.setLoginProtocol(this.getLoginProtocolInput());
        projectDeployEntity.setLoginPort(Integer.valueOf(this.getLoginPortInput()));
        projectDeployEntity.setLoginAccount(this.getLoginAccountInput());
        projectDeployEntity.setLoginPassword(this.getLoginPasswordInput());
        projectDeployEntity.setCreateDateTime(date);
        projectDeployEntity.setUpdateDateTime(date);
        return projectDeployEntity;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
