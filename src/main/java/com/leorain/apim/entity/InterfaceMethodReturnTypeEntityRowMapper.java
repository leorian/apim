package com.leorain.apim.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xiezg@317hu.com on 2017/7/1 0001.
 */
public class InterfaceMethodReturnTypeEntityRowMapper implements RowMapper<InterfaceMethodReturnTypeEntity> {
    @Override
    public InterfaceMethodReturnTypeEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        InterfaceMethodReturnTypeEntity interfaceMethodReturnTypeEntity = new InterfaceMethodReturnTypeEntity();
        interfaceMethodReturnTypeEntity.setReturnTypeId(resultSet.getLong("returnTypeId"));
        interfaceMethodReturnTypeEntity.setInterfaceMethodId(resultSet.getLong("interfaceMethodId"));
        interfaceMethodReturnTypeEntity.setMethodId(resultSet.getLong("methodId"));
        interfaceMethodReturnTypeEntity.setReturnTypeShortName(resultSet.getString("returnTypeShortName"));
        interfaceMethodReturnTypeEntity.setReturnTypeFullName(resultSet.getString("returnTypeFullName"));
        interfaceMethodReturnTypeEntity.setCode(resultSet.getString("code"));
        interfaceMethodReturnTypeEntity.setCreateUserId(resultSet.getLong("createUserId"));
        interfaceMethodReturnTypeEntity.setCreateDateTime(resultSet.getDate("createDateTime"));
        interfaceMethodReturnTypeEntity.setUpdateUserId(resultSet.getLong("updateUserId"));
        interfaceMethodReturnTypeEntity.setUpdateDateTime(resultSet.getDate("updateDateTime"));
        return interfaceMethodReturnTypeEntity;
    }
}
