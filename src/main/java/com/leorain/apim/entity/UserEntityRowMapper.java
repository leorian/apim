package com.leorain.apim.entity;


import com.leorain.apim.enums.UserSexEnum;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xiezg@317hu.com on 2017/7/1 0001.
 */
public class UserEntityRowMapper implements RowMapper<UserEntity> {

    @Override
    public UserEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(resultSet.getLong("id"));
        userEntity.setUserName(resultSet.getString("userName"));
        userEntity.setPassWord(resultSet.getString("passWord"));
        userEntity.setUserSex(UserSexEnum.valueOf(resultSet.getString("user_sex")));
        userEntity.setNickName(resultSet.getString("nick_name"));
        return userEntity;
    }
}
