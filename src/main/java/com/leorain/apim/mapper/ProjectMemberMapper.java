package com.leorain.apim.mapper;

import com.leorain.apim.entity.ProjectMemberEntity;
import com.leorain.apim.mapper.base.BaseMapper;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface ProjectMemberMapper extends BaseMapper<ProjectMemberEntity> {

    /**
     * 根据项目ID查询项目成员
     *
     * @param projectId
     * @return
     */
    List<ProjectMemberEntity> getAllByProjectId(Long projectId);

    /**
     * 根据项目ID删除项目成员
     *
     * @param projectId
     */
    void deleteProjectMemberByProjectId(Long projectId);
}
