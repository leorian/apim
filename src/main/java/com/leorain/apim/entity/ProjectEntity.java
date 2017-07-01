package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 项目表
 */
public class ProjectEntity extends BaseEntity{

    /**
     * 项目ID
     */
    private Long projectId;

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
    private Long projectManager;

    public ProjectEntity() {
    }

    public ProjectEntity(Long projectId, String projectName, String projectDescribe, Long projectManager) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDescribe = projectDescribe;
        this.projectManager = projectManager;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
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

    public Long getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Long projectManager) {
        this.projectManager = projectManager;
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
