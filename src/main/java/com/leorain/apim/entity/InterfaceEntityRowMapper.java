package com.leorain.apim.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xiezg@317hu.com on 2017/7/1 0001.
 */
public class InterfaceEntityRowMapper implements RowMapper<InterfaceEntity> {
    @Override
    public InterfaceEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        InterfaceEntity interfaceEntity = new InterfaceEntity();
        interfaceEntity.setInterfaceId(resultSet.getLong("interfaceId"));
        interfaceEntity.setProjectId(resultSet.getLong("projectId"));
        interfaceEntity.setInterfaceName(resultSet.getString("interfaceName"));
        interfaceEntity.setInterfaceType(resultSet.getInt("interfaceType"));
        interfaceEntity.setInterfaceAddress(resultSet.getString("interfaceAddress"));
        interfaceEntity.setRequestMethod(resultSet.getInt("requestMethod"));
        interfaceEntity.setCreateUserId(resultSet.getLong("createUserId"));
        interfaceEntity.setCreateDateTime(resultSet.getDate("createDateTime"));
        interfaceEntity.setUpdateUserId(resultSet.getLong("updateUserId"));
        interfaceEntity.setUpdateDateTime(resultSet.getDate("updateDateTime"));
        return interfaceEntity;
    }
}
