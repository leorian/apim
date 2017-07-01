package com.leorain.apim.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xiezg@317hu.com on 2017/7/1 0001.
 */
public class InterfaceRequestEntityRowMapper implements RowMapper<InterfaceRequestEntity> {
    @Override
    public InterfaceRequestEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        InterfaceRequestEntity interfaceRequestEntity = new InterfaceRequestEntity();
        interfaceRequestEntity.setInterfaceRequestId(resultSet.getLong("interfaceRequestId"));
        interfaceRequestEntity.setInterfaceId(resultSet.getLong("interfaceId"));
        interfaceRequestEntity.setLocation(resultSet.getInt("location"));
        interfaceRequestEntity.setRequestParameterName(resultSet.getString("requestParameterName"));
        interfaceRequestEntity.setRequestParameterType(resultSet.getString("requestParameterType"));
        interfaceRequestEntity.setParameterRequired(resultSet.getInt("parameterRequired"));
        interfaceRequestEntity.setParameterDescribe(resultSet.getString("parameterDescribe"));
        interfaceRequestEntity.setCreateUserId(resultSet.getLong("createUserId"));
        interfaceRequestEntity.setCreateDateTime(resultSet.getDate("createDateTime"));
        interfaceRequestEntity.setUpdateUserId(resultSet.getLong("updateUserId"));
        interfaceRequestEntity.setUpdateDateTime(resultSet.getDate("updateDateTime"));
        return interfaceRequestEntity;
    }
}
