package com.leorain.apim.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xiezg@317hu.com on 2017/7/1 0001.
 */
public class InterfaceMethodEntityRowMapper implements RowMapper<InterfaceMethodEntity> {
    @Override
    public InterfaceMethodEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        InterfaceMethodEntity interfaceMethodEntity = new InterfaceMethodEntity();
        interfaceMethodEntity.setInterfaceMethodId(resultSet.getLong("interfaceMethodId"));
        interfaceMethodEntity.setInterfaceId(resultSet.getLong("interfaceId"));
        interfaceMethodEntity.setInterfaceMethodName(resultSet.getString("interfaceMethodName"));
        interfaceMethodEntity.setFunctionDescribe(resultSet.getString("functionDescribe"));
        interfaceMethodEntity.setMethodParameter(resultSet.getString("methodParameter"));
        interfaceMethodEntity.setReturnType(resultSet.getString("returnType"));
        interfaceMethodEntity.setCreateUserId(resultSet.getLong("createUserId"));
        interfaceMethodEntity.setCreateDateTime(resultSet.getDate("createDateTime"));
        interfaceMethodEntity.setUpdateUserId(resultSet.getLong("updateUserId"));
        interfaceMethodEntity.setUpdateDateTime(resultSet.getDate("updateDateTime"));
        return interfaceMethodEntity;
    }
}
