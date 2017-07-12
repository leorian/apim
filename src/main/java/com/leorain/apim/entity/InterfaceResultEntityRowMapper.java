package com.leorain.apim.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xiezg@317hu.com on 2017/7/12 0012.
 */
public class InterfaceResultEntityRowMapper implements RowMapper<InterfaceResultEntity> {
    @Override
    public InterfaceResultEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        InterfaceResultEntity interfaceResultEntity = new InterfaceResultEntity();
        interfaceResultEntity.setId(resultSet.getLong("id"));
        interfaceResultEntity.setInterfaceId(resultSet.getLong("interfaceId"));
        interfaceResultEntity.setInterfaceType(resultSet.getString("interfaceType"));
        interfaceResultEntity.setExampleType(resultSet.getString("exampleType"));
        interfaceResultEntity.setExampleContent(resultSet.getString("exampleContent"));
        interfaceResultEntity.setAttentionMatters(resultSet.getString("attentionMatters"));
        interfaceResultEntity.setCreateUserId(resultSet.getLong("createUserId"));
        interfaceResultEntity.setCreateDateTime(resultSet.getDate("createDateTime"));
        interfaceResultEntity.setUpdateUserId(resultSet.getLong("updateUserId"));
        interfaceResultEntity.setUpdateDateTime(resultSet.getDate("updateDateTime"));
        return interfaceResultEntity;
    }
}
