package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 项目成员表
 */
public class ProjectMemberEntity {
    /**
     * 项目成员Id
     */
    private long projectMemberId;

    /**
     * 项目ID
     */
    private long projectId;

    /**
     * 用户ID
     */
    private long userId;

    public long getProjectMemberId() {
        return projectMemberId;
    }

    public void setProjectMemberId(long projectMemberId) {
        this.projectMemberId = projectMemberId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
