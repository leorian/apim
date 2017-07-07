package com.leorain.apim.domain;

import com.alibaba.fastjson.JSON;
import com.leorain.apim.entity.ProjectEntity;
import com.leorain.apim.entity.ProjectMemberEntity;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/7 0007.
 */
public class ProjectDomain implements Serializable {
    private String projectNameInput;
    private String projectDescribeInput;
    private String projectManagerInput;
    private String projectMembersInput;

    public String getProjectNameInput() {
        return projectNameInput;
    }

    public void setProjectNameInput(String projectNameInput) {
        this.projectNameInput = projectNameInput;
    }

    public String getProjectDescribeInput() {
        return projectDescribeInput;
    }

    public void setProjectDescribeInput(String projectDescribeInput) {
        this.projectDescribeInput = projectDescribeInput;
    }

    public String getProjectManagerInput() {
        return projectManagerInput;
    }

    public void setProjectManagerInput(String projectManagerInput) {
        this.projectManagerInput = projectManagerInput;
    }

    public String getProjectMembersInput() {
        return projectMembersInput;
    }

    public void setProjectMembersInput(String projectMembersInput) {
        this.projectMembersInput = projectMembersInput;
    }

    /**
     * 构造项目实体
     *
     * @return
     */
    public ProjectEntity buildProjectEntity() {
        ProjectEntity projectEntity = new ProjectEntity();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        projectEntity.setProjectId(Long.valueOf(simpleDateFormat.format(date)));
        projectEntity.setProjectName(this.getProjectNameInput());
        projectEntity.setProjectDescribe(this.getProjectDescribeInput());
        projectEntity.setProjectManager(Long.valueOf(this.getProjectManagerInput()));
        projectEntity.setCreateDateTime(date);
        projectEntity.setUpdateDateTime(date);
        return projectEntity;
    }

    /**
     * 构造项目成员实体
     *
     * @param projectId
     * @return
     */
    public List<ProjectMemberEntity> buildProjectMemberEntity(Long projectId) {
        if (!StringUtils.isEmpty(this.getProjectMembersInput())) {
            String[] projectMemberArray = this.getProjectMembersInput().split(",");
            List<ProjectMemberEntity> projectMemberEntityList = new ArrayList<>(projectMemberArray.length);
            for (String projectMember : projectMemberArray) {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
                ProjectMemberEntity projectMemberEntity = new ProjectMemberEntity();
                projectMemberEntity.setProjectMemberId(Long.valueOf(simpleDateFormat.format(date)));
                projectMemberEntity.setProjectId(projectId);
                projectMemberEntity.setUserId(Long.valueOf(projectMember));
                projectMemberEntity.setCreateDateTime(date);
                projectMemberEntity.setUpdateDateTime(date);
                projectMemberEntityList.add(projectMemberEntity);
            }

            return projectMemberEntityList;
        }
        return null;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
