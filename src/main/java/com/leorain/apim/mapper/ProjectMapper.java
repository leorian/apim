package com.leorain.apim.mapper;

import com.leorain.apim.entity.ProjectEntity;
import com.leorain.apim.mapper.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface ProjectMapper extends BaseMapper<ProjectEntity> {
    /**
     * @return
     */
    List<ProjectEntity> getAllWithDetail();

    /**
     * @param projectIdList
     * @return
     */
    List<ProjectEntity> getMemberCountByProjectList(List<Long> projectIdList);
}
