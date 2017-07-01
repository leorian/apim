package com.leorain.apim.sevice;

import com.leorain.apim.entity.ProjectMemberEntity;
import com.leorain.apim.tools.JqPage;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface ProjectMemberService {

    /**
     * 根据项目成员ID查询单个项目成员信息
     *
     * @param projectMemberId
     * @return
     */
    ProjectMemberEntity findProjectMemberEntity(Long projectMemberId);

    /**
     * 查询所有项目成员信息
     *
     * @return
     */
    List<ProjectMemberEntity> findProjectMemberEntityList();

    /**
     * 分页查询所有
     *
     * @param jqPage
     * @param projectMemberEntity
     * @return
     */
    JqPage<ProjectMemberEntity> findProjectMemberEntityPage(JqPage jqPage, ProjectMemberEntity projectMemberEntity);
}
