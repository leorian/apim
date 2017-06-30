package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 项目表
 */
public class ProjectEntity {

    /**
     * 项目ID
     */
    private long projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目描述
     */
    private String projectDescribe;

    /**
     * 项目描述
     */
    private long projectManager;

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescribe() {
        return projectDescribe;
    }

    public void setProjectDescribe(String projectDescribe) {
        this.projectDescribe = projectDescribe;
    }

    public long getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(long projectManager) {
        this.projectManager = projectManager;
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
