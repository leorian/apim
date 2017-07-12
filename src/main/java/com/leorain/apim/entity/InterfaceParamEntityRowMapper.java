package com.leorain.apim.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xiezg@317hu.com on 2017/7/12 0012.
 */
public class InterfaceParamEntityRowMapper implements RowMapper<InterfaceParamEntity> {
    @Override
    public InterfaceParamEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        InterfaceParamEntity interfaceParamEntity = new InterfaceParamEntity();
        interfaceParamEntity.setId(resultSet.getLong("id"));
        interfaceParamEntity.setInterfaceId(resultSet.getLong("interfaceId"));
        interfaceParamEntity.setInterfaceType(resultSet.getString("interfaceType"));
        interfaceParamEntity.setParamName(resultSet.getString("paramName"));
        interfaceParamEntity.setParamType(resultSet.getString("paramType"));
        interfaceParamEntity.setParamDescribe(resultSet.getString("paramDescribe"));
        interfaceParamEntity.setRequired(resultSet.getBoolean("required"));
        interfaceParamEntity.setJsontransformat(resultSet.getBoolean("jsontransformat"));
        interfaceParamEntity.setExample(resultSet.getString("example"));
        interfaceParamEntity.setDefaultValue(resultSet.getString("defaultValue"));
        interfaceParamEntity.setCreateUserId(resultSet.getLong("createUserId"));
        interfaceParamEntity.setCreateDateTime(resultSet.getDate("createDateTime"));
        interfaceParamEntity.setUpdateUserId(resultSet.getLong("updateUserId"));
        interfaceParamEntity.setUpdateDateTime(resultSet.getDate("updateDateTime"));
        return interfaceParamEntity;
    }
}
