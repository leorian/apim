package com.leorain.apim.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xiezg@317hu.com on 2017/7/7 0007.
 */
public class ProjectDeployEntityRowMapper implements RowMapper<ProjectDeployEntity> {
    @Override
    public ProjectDeployEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        ProjectDeployEntity projectDeployEntity = new ProjectDeployEntity();
        projectDeployEntity.setDeployId(resultSet.getLong("deployId"));
        projectDeployEntity.setProjectId(resultSet.getLong("projectId"));
        projectDeployEntity.setEnv(resultSet.getString("env"));
        projectDeployEntity.setIp(resultSet.getString("ip"));
        projectDeployEntity.setPort(resultSet.getInt("port"));
        projectDeployEntity.setPath(resultSet.getString("path"));
        projectDeployEntity.setCreateUserId(resultSet.getLong("createUserId"));
        projectDeployEntity.setCreateDateTime(resultSet.getDate("createDateTime"));
        projectDeployEntity.setUpdateUserId(resultSet.getLong("updateUserId"));
        projectDeployEntity.setUpdateDateTime(resultSet.getDate("updateDateTime"));
        return projectDeployEntity;
    }
}
