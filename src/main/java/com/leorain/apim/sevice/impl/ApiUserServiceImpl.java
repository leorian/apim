package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.ApiUserEntity;
import com.leorain.apim.entity.ApiUserEntityRowMapper;
import com.leorain.apim.mapper.ApiUserMapper;
import com.leorain.apim.sevice.ApiUserService;
import com.leorain.apim.tools.JqPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class ApiUserServiceImpl implements ApiUserService {

    @Autowired
    private ApiUserMapper apiUserMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ApiUserEntity findApiUserEntity(Long userId) {
        return apiUserMapper.getOne(userId);
    }

    @Override
    public List<ApiUserEntity> findApiUserEntityList() {
        return apiUserMapper.getAll();
    }

    @Override
    public JqPage<ApiUserEntity> findApiUserEntityPage(JqPage jqPage, ApiUserEntity apiUserEntity) {
        String countSQL = " SELECT COUNT(*) FROM T_API_USER ";
        String resultSQL = " SELECT * FROM T_API_USER LIMIT ? , ?";
        jqPage.setRecords(jdbcTemplate.queryForObject(countSQL, int.class));
        Object[] args = {jqPage.getFromIndex(), jqPage.getPageSize()};
        jqPage.setRows(jdbcTemplate.query(resultSQL, args, new ApiUserEntityRowMapper()));
        return jqPage;
    }
}
