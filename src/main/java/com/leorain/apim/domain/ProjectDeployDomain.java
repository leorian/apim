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
        projectDeployEntity.setCreateDateTime(date);
        projectDeployEntity.setUpdateDateTime(date);
        return projectDeployEntity;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
