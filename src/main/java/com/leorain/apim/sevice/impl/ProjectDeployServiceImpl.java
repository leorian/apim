package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.ProjectDeployEntity;
import com.leorain.apim.entity.ProjectDeployEntityRowMapper;
import com.leorain.apim.sevice.ProjectDeployService;
import com.leorain.apim.tools.JqPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by xiezg@317hu.com on 2017/7/7 0007.
 */
@Service
public class ProjectDeployServiceImpl implements ProjectDeployService {
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
}
