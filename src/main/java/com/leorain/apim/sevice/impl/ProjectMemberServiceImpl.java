package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.ProjectMemberEntity;
import com.leorain.apim.entity.ProjectMemberEntityRowMapper;
import com.leorain.apim.mapper.ProjectMemberMapper;
import com.leorain.apim.sevice.ProjectMemberService;
import com.leorain.apim.tools.JqPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {

    @Autowired
    private ProjectMemberMapper projectMemberMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ProjectMemberEntity findProjectMemberEntity(Long projectMemberId) {
        return projectMemberMapper.getOne(projectMemberId);
    }

    @Override
    public List<ProjectMemberEntity> findProjectMemberEntityList() {
        return projectMemberMapper.getAll();
    }

    @Override
    public JqPage<ProjectMemberEntity> findProjectMemberEntityPage(JqPage jqPage, ProjectMemberEntity projectMemberEntity) {
        String countSQL = " SELECT COUNT(*) FROM T_API_PROJECT_MEMBER ";
        String resultSQL = " SELECT * FROM T_API_PROJECT_MEMBER LIMIT ?, ?";
        jqPage.setRecords(jdbcTemplate.queryForObject(countSQL, int.class));
        Object[] args = {jqPage.getFromIndex(), jqPage.getPageSize()};
        jqPage.setRows(jdbcTemplate.query(resultSQL, args, new ProjectMemberEntityRowMapper()));
        return jqPage;
    }

    @Override
    public void insertProjectMemberEntity(ProjectMemberEntity projectMemberEntity) {
        projectMemberMapper.insert(projectMemberEntity);
    }
}
