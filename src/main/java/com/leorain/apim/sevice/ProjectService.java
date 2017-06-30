package com.leorain.apim.sevice;

import com.leorain.apim.entity.ProjectEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface ProjectService {
    /**
     *
     * @param projectId
     * @return
     */
    ProjectEntity findProjectEntity(Long projectId);

    /**
     *
     * @return
     */
    List<ProjectEntity> findProjectEntityList();
}
