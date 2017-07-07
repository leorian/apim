package com.leorain.apim.sevice;

import com.leorain.apim.entity.ProjectDeployEntity;
import com.leorain.apim.tools.JqPage;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/7 0007.
 */
public interface ProjectDeployService {
    /**
     * 分页查询项目部署情况信息
     *
     * @param jqPage
     * @param projectDeployEntity
     * @return
     */
    JqPage<ProjectDeployEntity> findProjectDeployEntityPage(JqPage jqPage, ProjectDeployEntity projectDeployEntity);

    /**
     * 新增机器
     *
     * @param projectDeployEntity
     */
    void insertProjectDeployEntity(ProjectDeployEntity projectDeployEntity);

    /**
     * 更新机器
     *
     * @param projectDeployEntity
     * @param deployId
     */
    void updateProjectDeployEntity(ProjectDeployEntity projectDeployEntity, Long deployId);

    /**
     * 根据项目ID获取机器列表信息
     *
     * @param projectId
     * @return
     */
    List<ProjectDeployEntity> getProjectDeployEntityListByProjectId(Long projectId);

    /**
     * 删除机器信息
     *
     * @param deployId
     */
    void deleteProjectDeployEntity(Long deployId);
}
