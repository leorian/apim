package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.ProjectEntity;
import com.leorain.apim.entity.ProjectEntityRowMapper;
import com.leorain.apim.mapper.ProjectMapper;
import com.leorain.apim.sevice.ProjectService;
import com.leorain.apim.tools.JqPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ProjectEntity findProjectEntity(Long projectId) {
        return projectMapper.getOne(projectId);
    }

    @Override
    public List<ProjectEntity> findProjectEntityList() {
        return projectMapper.getAll();
    }

    @Override
    public JqPage<ProjectEntity> findProjectEntityPage(JqPage jqPage, ProjectEntity projectEntity) {
        String countSQL = " SELECT COUNT(*) FROM T_API_PROJECT tap LEFT JOIN T_API_USER tau ON tap.projectManager = tau.userId ";
        String resultSQL = " SELECT tap.projectId AS  projectId, tap.projectName AS projectName, tap.projectDescribe AS projectDescribe, " +
                " tap.projectManager AS projectManager, tap.createUserId AS createUserId, tap.createDateTime AS createDateTime, " +
                " tap.updateUserId AS updateUserId, tap.updateDateTime AS updateDateTime, tau.cnName AS projectManagerText " +
                " FROM T_API_PROJECT tap LEFT JOIN T_API_USER tau ON tap.projectManager = tau.userId LIMIT ?, ? ";
        jqPage.setRecords(jdbcTemplate.queryForObject(countSQL, int.class));
        Object[] args = {jqPage.getFromIndex(), jqPage.getPageSize()};
        jqPage.setRows(jdbcTemplate.query(resultSQL, args, new ProjectEntityRowMapper()));
        return jqPage;
    }

    @Override
    public void insertProject(ProjectEntity projectEntity) {
        projectMapper.insert(projectEntity);
    }
}
