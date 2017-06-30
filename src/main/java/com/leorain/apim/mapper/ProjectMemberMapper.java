package com.leorain.apim.mapper;

import com.leorain.apim.entity.ProjectMemberEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface ProjectMemberMapper {
    List<ProjectMemberEntity> getAll();

    ProjectMemberEntity getOne(Long id);

    void insert(ProjectMemberEntity projectMemberEntity);

    void update(ProjectMemberEntity projectMemberEntity);

    void delete(Long id);
}
