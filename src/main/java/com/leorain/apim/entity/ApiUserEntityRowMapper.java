package com.leorain.apim.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xiezg@317hu.com on 2017/7/1 0001.
 */
public class ApiUserEntityRowMapper implements RowMapper<ApiUserEntity> {
    @Override
    public ApiUserEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        ApiUserEntity apiUserEntity = new ApiUserEntity();
        apiUserEntity.setUserId(resultSet.getLong("userId"));
        apiUserEntity.setUserIdText(String.valueOf(apiUserEntity.getUserId()));
        apiUserEntity.setUsName(resultSet.getString("usName"));
        apiUserEntity.setCnName(resultSet.getString("cnName"));
        apiUserEntity.setUserRole(resultSet.getInt("userRole"));
        apiUserEntity.setCellPhone(resultSet.getString("cellPhone"));
        apiUserEntity.setEmail(resultSet.getString("email"));
        apiUserEntity.setPassword(resultSet.getString("password"));
        apiUserEntity.setCreateUserId(resultSet.getLong("createUserId"));
        apiUserEntity.setCreateDateTime(resultSet.getDate("createDateTime"));
        apiUserEntity.setUpdateUserId(resultSet.getLong("updateUserId"));
        apiUserEntity.setUpdateDateTime(resultSet.getDate("updateDateTime"));
        return apiUserEntity;
    }
}
