package com.leorain.apim.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xiezg@317hu.com on 2017/7/1 0001.
 */
public class InterfaceResponseEntityRowMapper implements RowMapper<InterfaceResponseEntity> {
    @Override
    public InterfaceResponseEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        InterfaceResponseEntity interfaceResponseEntity = new InterfaceResponseEntity();
        interfaceResponseEntity.setInterfaceResponseId(resultSet.getLong("interfaceResponseId"));
        interfaceResponseEntity.setInterfaceId(resultSet.getLong("interfaceId"));
        interfaceResponseEntity.setScene(resultSet.getInt("scene"));
        interfaceResponseEntity.setResponseReturnMode(resultSet.getInt("responseReturnMode"));
        interfaceResponseEntity.setResponseExample(resultSet.getString("responseExample"));
        interfaceResponseEntity.setResponseRemark(resultSet.getString("responseRemark"));
        interfaceResponseEntity.setCreateUserId(resultSet.getLong("createUserId"));
        interfaceResponseEntity.setCreateDateTime(resultSet.getDate("createDateTime"));
        interfaceResponseEntity.setUpdateUserId(resultSet.getLong("updateUserId"));
        interfaceResponseEntity.setUpdateDateTime(resultSet.getDate("updateDateTime"));
        return interfaceResponseEntity;
    }
}
