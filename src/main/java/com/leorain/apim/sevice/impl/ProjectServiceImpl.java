package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.ProjectEntity;
import com.leorain.apim.mapper.ProjectMapper;
import com.leorain.apim.sevice.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public ProjectEntity findProjectEntity(Long projectId) {
        return projectMapper.getOne(projectId);
    }

    @Override
    public List<ProjectEntity> findProjectEntityList() {
        return projectMapper.getAll();
    }
}
