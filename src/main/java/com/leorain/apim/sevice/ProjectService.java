package com.leorain.apim.sevice;

import com.leorain.apim.entity.ProjectEntity;
import com.leorain.apim.tools.JqPage;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface ProjectService {
    /**
     * @param projectId
     * @return
     */
    ProjectEntity findProjectEntity(Long projectId);

    /**
     * @return
     */
    List<ProjectEntity> findProjectEntityList();

    /**
     * @param jqPage
     * @param projectEntity
     * @return
     */
    JqPage<ProjectEntity> findProjectEntityPage(JqPage jqPage, ProjectEntity projectEntity);

    /**
     * 新增项目实体信息
     *
     * @param projectEntity
     */
    void insertProject(ProjectEntity projectEntity);
}
