package com.leorain.apim.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xiezg@317hu.com on 2017/7/1 0001.
 */
public class ProjectEntityRowMapper implements RowMapper<ProjectEntity> {
    @Override
    public ProjectEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectId(resultSet.getLong("projectId"));
        projectEntity.setProjectName(resultSet.getString("projectName"));
        projectEntity.setProjectDescribe(resultSet.getString("projectDescribe"));
        projectEntity.setProjectManager(resultSet.getLong("projectManager"));
        projectEntity.setCreateUserId(resultSet.getLong("createUserId"));
        projectEntity.setCreateDateTime(resultSet.getDate("createDateTime"));
        projectEntity.setUpdateUserId(resultSet.getLong("updateUserId"));
        projectEntity.setUpdateDateTime(resultSet.getDate("updateDateTime"));
        return projectEntity;
    }
}
