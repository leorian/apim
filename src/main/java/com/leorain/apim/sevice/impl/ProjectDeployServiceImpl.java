package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.ProjectDeployEntity;
import com.leorain.apim.entity.ProjectDeployEntityRowMapper;
import com.leorain.apim.mapper.ProjectDeployMapper;
import com.leorain.apim.sevice.ProjectDeployService;
import com.leorain.apim.tools.JqPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/7 0007.
 */
@Service
public class ProjectDeployServiceImpl implements ProjectDeployService {

    @Autowired
    private ProjectDeployMapper projectDeployMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public JqPage<ProjectDeployEntity> findProjectDeployEntityPage(JqPage jqPage, ProjectDeployEntity projectDeployEntity) {
        String countSQL = " SELECT COUNT(*) FROM T_API_PROJECT_DEPLOY ";
        String resultSQL = " SELECT * FROM T_API_PROJECT_DEPLOY LIMIT ?,? ";
        jqPage.setRecords(jdbcTemplate.queryForObject(countSQL, int.class));
        Object[] args = {jqPage.getFromIndex(), jqPage.getPageSize()};
        jqPage.setRows(jdbcTemplate.query(resultSQL, args, new ProjectDeployEntityRowMapper()));
        return jqPage;
    }

    @Override
    public void insertProjectDeployEntity(ProjectDeployEntity projectDeployEntity) {
        projectDeployMapper.insert(projectDeployEntity);
    }

    @Override
    public List<ProjectDeployEntity> getProjectDeployEntityListByProjectId(Long projectId) {
        List<ProjectDeployEntity> projectDeployEntities = projectDeployMapper.getAllByProjectId(projectId);
        if (!CollectionUtils.isEmpty(projectDeployEntities)) {
            for (ProjectDeployEntity projectDeployEntity : projectDeployEntities) {
                projectDeployEntity.setDeployIdText(String.valueOf(projectDeployEntity.getDeployId()));
                projectDeployEntity.setProjectIdText(String.valueOf(projectDeployEntity.getProjectId()));
            }
        }
        return projectDeployEntities;
    }
}
