package com.leorain.apim.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xiezg@317hu.com on 2017/7/1 0001.
 */
public class InterfaceMethodParameterEntityRowMapper implements RowMapper<InterfaceMethodParameterEntity> {
    @Override
    public InterfaceMethodParameterEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        InterfaceMethodParameterEntity interfaceMethodParameterEntity = new InterfaceMethodParameterEntity();
        interfaceMethodParameterEntity.setParameterId(resultSet.getLong("parameterId"));
        interfaceMethodParameterEntity.setInterfaceMethodId(resultSet.getLong("interfaceMethodId"));
        interfaceMethodParameterEntity.setMethodId(resultSet.getLong("methodId"));
        interfaceMethodParameterEntity.setParameterIndex(resultSet.getInt("parameterIndex"));
        interfaceMethodParameterEntity.setParameterTypeShortName(resultSet.getString("parameterTypeShortName"));
        interfaceMethodParameterEntity.setParameterTypeFullName(resultSet.getString("parameterTypeFullName"));
        interfaceMethodParameterEntity.setParameterName(resultSet.getString("parameterName"));
        interfaceMethodParameterEntity.setParameterMeaning(resultSet.getString("parameterMeaning"));
        interfaceMethodParameterEntity.setParameterRequired(resultSet.getInt("parameterRequired"));
        interfaceMethodParameterEntity.setCode(resultSet.getString("code"));
        interfaceMethodParameterEntity.setCreateUserId(resultSet.getLong("createUserId"));
        interfaceMethodParameterEntity.setCreateDateTime(resultSet.getDate("createDateTime"));
        interfaceMethodParameterEntity.setUpdateUserId(resultSet.getLong("updateUserId"));
        interfaceMethodParameterEntity.setUpdateDateTime(resultSet.getDate("updateDateTime"));
        return interfaceMethodParameterEntity;
    }
}
