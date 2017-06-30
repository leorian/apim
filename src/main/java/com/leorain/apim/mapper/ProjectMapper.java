package com.leorain.apim.mapper;

import com.leorain.apim.entity.ProjectEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface ProjectMapper {
    List<ProjectEntity> getAll();

    ProjectEntity getOne(Long id);

    void insert(ProjectEntity projectEntity);

    void update(ProjectEntity projectEntity);

    void delete(Long id);
}
