package com.leorain.apim.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xiezg@317hu.com on 2017/7/1 0001.
 */
public class ProjectMemberEntityRowMapper implements RowMapper<ProjectMemberEntity> {
    @Override
    public ProjectMemberEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        ProjectMemberEntity projectMemberEntity = new ProjectMemberEntity();
        projectMemberEntity.setProjectMemberId(resultSet.getLong("projectMemberId"));
        projectMemberEntity.setProjectId(resultSet.getLong("projectId"));
        projectMemberEntity.setUserId(resultSet.getLong("userId"));
        projectMemberEntity.setCreateUserId(resultSet.getLong("createUserId"));
        projectMemberEntity.setCreateDateTime(resultSet.getDate("createDateTime"));
        projectMemberEntity.setUpdateUserId(resultSet.getLong("updateUserId"));
        projectMemberEntity.setUpdateDateTime(resultSet.getDate("updateDateTime"));
        return projectMemberEntity;
    }
}
