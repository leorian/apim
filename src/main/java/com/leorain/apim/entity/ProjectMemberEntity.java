package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 项目成员表
 */
public class ProjectMemberEntity extends BaseEntity {
    /**
     * 项目成员Id
     */
    private Long projectMemberId;

    /**
     * 项目成员ID 防止long精度丢失
     */
    private String projectMemberIdText;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 项目ID 防止long精度丢失
     */
    private String projectIdText;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户ID 防止long精度丢失
     */
    private String userIdText;

    /**
     * 用户名称
     */
    private String userName;

    public ProjectMemberEntity() {
    }

    public ProjectMemberEntity(Long projectMemberId, Long projectId, Long userId) {
        this.projectMemberId = projectMemberId;
        this.projectId = projectId;
        this.userId = userId;
    }

    public Long getProjectMemberId() {
        return projectMemberId;
    }

    public void setProjectMemberId(Long projectMemberId) {
        this.projectMemberId = projectMemberId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getProjectMemberIdText() {
        return projectMemberIdText;
    }

    public void setProjectMemberIdText(String projectMemberIdText) {
        this.projectMemberIdText = projectMemberIdText;
    }

    public String getProjectIdText() {
        return projectIdText;
    }

    public void setProjectIdText(String projectIdText) {
        this.projectIdText = projectIdText;
    }

    public String getUserIdText() {
        return userIdText;
    }

    public void setUserIdText(String userIdText) {
        this.userIdText = userIdText;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
