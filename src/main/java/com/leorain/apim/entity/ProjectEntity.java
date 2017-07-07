package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 项目表
 */
public class ProjectEntity extends BaseEntity {

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 项目ID纯文本，防止long类型精度丢失
     */
    private String projectIdText;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目描述
     */
    private String projectDescribe;

    /**
     * 项目经理
     */
    private Long projectManager;

    /**
     * 项目经理名称
     */
    private String projectManagerText;

    /**
     * 接口总数
     */
    private Integer interfaceCount = 0;

    /**
     * 组内人员总数
     */
    private Integer memberCount = 0;

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

    public String getProjectIdText() {
        return projectIdText;
    }

    public void setProjectIdText(String projectIdText) {
        this.projectIdText = projectIdText;
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

    public String getProjectManagerText() {
        return projectManagerText;
    }

    public void setProjectManagerText(String projectManagerText) {
        this.projectManagerText = projectManagerText;
    }

    public Integer getInterfaceCount() {
        return interfaceCount;
    }

    public void setInterfaceCount(Integer interfaceCount) {
        this.interfaceCount = interfaceCount;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
