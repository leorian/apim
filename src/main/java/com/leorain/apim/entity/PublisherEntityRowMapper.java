package com.leorain.apim.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xiezg@317hu.com on 2017/7/1 0001.
 */
public class PublisherEntityRowMapper implements RowMapper<PublisherEntity> {
    @Override
    public PublisherEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        PublisherEntity publisherEntity = new PublisherEntity();
        publisherEntity.setPublisherId(resultSet.getLong("publisherId"));
        publisherEntity.setInterfaceId(resultSet.getLong("interfaceId"));
        publisherEntity.setEnvironment(resultSet.getInt("environment"));
        publisherEntity.setInterfaceRealAddress(resultSet.getString("interfaceRealAddress"));
        publisherEntity.setGroupName(resultSet.getString("groupName"));
        publisherEntity.setVersion(resultSet.getString("version"));
        publisherEntity.setCreateUserId(resultSet.getLong("createUserId"));
        publisherEntity.setCreateDateTime(resultSet.getDate("createDateTime"));
        publisherEntity.setUpdateUserId(resultSet.getLong("updateUserId"));
        publisherEntity.setUpdateDateTime(resultSet.getDate("updateDateTime"));
        return publisherEntity;
    }
}
