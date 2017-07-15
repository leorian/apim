package com.leorain.apim.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xiezhonggui on 2017/7/15.
 */
public class InterfaceRpcEntityRowMapper implements RowMapper<InterfaceRpcEntity> {
    @Override
    public InterfaceRpcEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        InterfaceRpcEntity interfaceRpcEntity = new InterfaceRpcEntity();
        interfaceRpcEntity.setId(resultSet.getLong("id"));
        interfaceRpcEntity.setAppId(resultSet.getLong("appId"));
        interfaceRpcEntity.setName(resultSet.getString("name"));
        interfaceRpcEntity.setClassName(resultSet.getString("className"));
        interfaceRpcEntity.setMethodName(resultSet.getString("methodName"));
        interfaceRpcEntity.setFunctionDescribe(resultSet.getString("functionDescribe"));
        interfaceRpcEntity.setReturnType(resultSet.getString("returnType"));
        interfaceRpcEntity.setMethodParam(resultSet.getString("methodParam"));
        interfaceRpcEntity.setCreateUserId(resultSet.getLong("createUserId"));
        interfaceRpcEntity.setCreateDateTime(resultSet.getDate("createDateTime"));
        interfaceRpcEntity.setUpdateUserId(resultSet.getLong("updateUserId"));
        interfaceRpcEntity.setUpdateDateTime(resultSet.getDate("updateDateTime"));
        return interfaceRpcEntity;
    }
}
