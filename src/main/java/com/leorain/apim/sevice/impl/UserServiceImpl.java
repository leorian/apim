package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.UserEntity;
import com.leorain.apim.entity.UserEntityRowMapper;
import com.leorain.apim.mapper.UserMapper;
import com.leorain.apim.sevice.UserService;
import com.leorain.apim.tools.JqPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public JqPage<UserEntity> findUserEntityPage(JqPage<UserEntity> jqPage, UserEntity userEntity) {
        String countSQL = " SELECT COUNT(*) FROM users ";
        String resultSQL = " SELECT * FROM users LIMIT ? , ?";
        jqPage.setRecords(jdbcTemplate.queryForObject(countSQL, int.class));
        Object[] args = {jqPage.getFromIndex(), jqPage.getPageSize()};
        jqPage.setRows(jdbcTemplate.query(resultSQL, args, new UserEntityRowMapper()));
        return jqPage;
    }
}
