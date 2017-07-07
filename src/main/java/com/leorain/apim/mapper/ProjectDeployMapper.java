package com.leorain.apim.mapper;

import com.leorain.apim.entity.ProjectDeployEntity;
import com.leorain.apim.mapper.base.BaseMapper;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/7 0007.
 */
public interface ProjectDeployMapper extends BaseMapper<ProjectDeployEntity> {

    /**
     * 根据项目ID获取机器信息
     *
     * @param projectId
     * @return
     */
    List<ProjectDeployEntity> getAllByProjectId(Long projectId);
}
