package com.leorain.apim.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xiezg@317hu.com on 2017/7/11 0011.
 */
public class InterfaceHttpEntityRowMapper implements RowMapper<InterfaceHttpEntity> {
    @Override
    public InterfaceHttpEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        InterfaceHttpEntity interfaceHttpEntity = new InterfaceHttpEntity();
        interfaceHttpEntity.setId(resultSet.getLong("id"));
        interfaceHttpEntity.setAppId(resultSet.getLong("appId"));
        interfaceHttpEntity.setProtocol(resultSet.getString("protocol"));
        interfaceHttpEntity.setMethod(resultSet.getString("method"));
        interfaceHttpEntity.setTransformat(resultSet.getString("transformat"));
        interfaceHttpEntity.setAddress(resultSet.getString("address"));
        interfaceHttpEntity.setName(resultSet.getString("name"));
        interfaceHttpEntity.setDescription(resultSet.getString("description"));
        interfaceHttpEntity.setCreateUserId(resultSet.getLong("createUserId"));
        interfaceHttpEntity.setCreateDateTime(resultSet.getDate("createDateTime"));
        interfaceHttpEntity.setUpdateUserId(resultSet.getLong("updateUserId"));
        interfaceHttpEntity.setUpdateDateTime(resultSet.getDate("updateDateTime"));
        return interfaceHttpEntity;
    }
}
