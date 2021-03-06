package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.ProjectEntity;
import com.leorain.apim.entity.ProjectEntityRowMapper;
import com.leorain.apim.entity.ProjectMemberEntity;
import com.leorain.apim.mapper.ProjectMapper;
import com.leorain.apim.mapper.ProjectMemberMapper;
import com.leorain.apim.sevice.ProjectService;
import com.leorain.apim.tools.JqPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private ProjectMemberMapper projectMemberMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ProjectEntity findProjectEntity(Long projectId) {
        ProjectEntity projectEntity = projectMapper.getOne(projectId);
        projectEntity.setProjectIdText(String.valueOf(projectEntity.getProjectId()));
        List<ProjectMemberEntity> projectMemberEntityList = projectMemberMapper.getAllByProjectId(projectEntity.getProjectId());
        if (!CollectionUtils.isEmpty(projectMemberEntityList)) {
            for (ProjectMemberEntity projectMemberEntity : projectMemberEntityList) {
                projectMemberEntity.setProjectMemberIdText(String.valueOf(projectMemberEntity.getProjectMemberId()));
                projectMemberEntity.setProjectIdText(String.valueOf(projectMemberEntity.getProjectId()));
                projectMemberEntity.setUserIdText(String.valueOf(projectMemberEntity.getUserId()));
            }
        }
        projectEntity.setProjectMemberEntities(projectMemberEntityList);
        return projectEntity;
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
                " FROM T_API_PROJECT tap LEFT JOIN T_API_USER tau ON tap.projectManager = tau.userId ";
        List<Object> list = new ArrayList<>();
        if (!StringUtils.isEmpty(projectEntity.getProjectName()) || !(projectEntity.getProjectManager() == null)) {
            countSQL = countSQL + " WHERE ";
            resultSQL = resultSQL + " WHERE ";
        }

        if (!StringUtils.isEmpty(projectEntity.getProjectName())) {
            countSQL = countSQL + " (tap.projectName LIKE ?) ";
            resultSQL = resultSQL + " (tap.projectName LIKE  ?) ";
            list.add("%" + projectEntity.getProjectName() + "%");
        }

        if (!StringUtils.isEmpty(projectEntity.getProjectName()) && !(projectEntity.getProjectManager() == null)) {
            countSQL = countSQL + " AND ";
            resultSQL = resultSQL + " AND ";
        }

        if (!(projectEntity.getProjectManager() == null)) {
            countSQL = countSQL + " (tap.projectManager = ?) ";
            resultSQL = resultSQL + " (tap.projectManager = ?) ";
            list.add(projectEntity.getProjectManager());
        }

        resultSQL = resultSQL + " LIMIT ?, ? ";
        if (CollectionUtils.isEmpty(list)) {
            jqPage.setRecords(jdbcTemplate.queryForObject(countSQL, int.class));
            Object[] args = {jqPage.getFromIndex(), jqPage.getPageSize()};
            jqPage.setRows(jdbcTemplate.query(resultSQL, args, new ProjectEntityRowMapper()));
        } else {
            jqPage.setRecords(jdbcTemplate.queryForObject(countSQL, list.toArray(), int.class));
            list.add(jqPage.getFromIndex());
            list.add(jqPage.getPageSize());
            jqPage.setRows(jdbcTemplate.query(resultSQL, list.toArray(), new ProjectEntityRowMapper()));
        }

        List<ProjectEntity> projectEntityList = jqPage.getRows();
        if (!CollectionUtils.isEmpty(projectEntityList)) {
            List<Long> projectIds = new ArrayList<>(projectEntityList.size());
            for (ProjectEntity pj : projectEntityList) {
                projectIds.add(pj.getProjectId());
            }

            List<ProjectEntity> projectEntities = projectMapper.getMemberCountByProjectList(projectIds);

            if (!CollectionUtils.isEmpty(projectEntities)) {
                Map<Long, Integer> map = new HashMap<>();
                for (ProjectEntity pj : projectEntities) {
                    map.put(pj.getProjectId(), pj.getMemberCount());
                }

                for (ProjectEntity pj : projectEntityList) {
                    pj.setMemberCount(map.get(pj.getProjectId()));
                }
            }
        }
        return jqPage;
    }

    @Override
    public void insertProjectEntity(ProjectEntity projectEntity) {
        projectMapper.insert(projectEntity);
    }

    @Override
    public void deleteProjectEntity(Long projectId) {
        projectMapper.delete(projectId);
    }

    @Override
    public void updateProjectEntity(ProjectEntity projectEntity, Long projectId) {
        projectEntity.setProjectId(projectId);
        projectMapper.update(projectEntity);
    }
}
