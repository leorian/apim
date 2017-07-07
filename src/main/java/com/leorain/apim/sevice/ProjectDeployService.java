package com.leorain.apim.sevice;

import com.leorain.apim.entity.ProjectDeployEntity;
import com.leorain.apim.tools.JqPage;

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
}
