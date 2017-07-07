package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.ApiUserEntity;
import com.leorain.apim.entity.ApiUserEntityRowMapper;
import com.leorain.apim.mapper.ApiUserMapper;
import com.leorain.apim.sevice.ApiUserService;
import com.leorain.apim.tools.JqPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
        ApiUserEntity apiUserEntity = apiUserMapper.getOne(userId);
        apiUserEntity.setUserIdText(String.valueOf(apiUserEntity.getUserId()));
        return apiUserEntity;
    }

    @Override
    public List<ApiUserEntity> findApiUserEntityList() {
        List<ApiUserEntity> apiUserEntityList = apiUserMapper.getAll();
        if (!CollectionUtils.isEmpty(apiUserEntityList)) {
            for (ApiUserEntity apiUserEntity : apiUserEntityList) {
                apiUserEntity.setUserIdText(String.valueOf(apiUserEntity.getUserId()));
            }
        }
        return apiUserEntityList;
    }

    @Override
    public JqPage<ApiUserEntity> findApiUserEntityPage(JqPage jqPage, ApiUserEntity apiUserEntity) {
        List<Object> objectList = new ArrayList<>();
        String countSQL = " SELECT COUNT(*) FROM T_API_USER ";
        String resultSQL = " SELECT * FROM T_API_USER ";

        if (!StringUtils.isEmpty(apiUserEntity.getCnName()) || !StringUtils.isEmpty(apiUserEntity.getEmail())) {
            countSQL = countSQL + " WHERE ";
            resultSQL = resultSQL + " WHERE ";
        }

        if (!StringUtils.isEmpty(apiUserEntity.getCnName())) {
            countSQL = countSQL + " (usName LIKE ? OR cnName LIKE ?)";
            resultSQL = resultSQL + " (usName LIKE ? OR cnName LIKE ?)";
            objectList.add("%" + apiUserEntity.getUsName() + "%");
            objectList.add("%" + apiUserEntity.getCnName() + "%");
        }

        if (!StringUtils.isEmpty(apiUserEntity.getCnName()) && !StringUtils.isEmpty(apiUserEntity.getEmail())) {
            countSQL = countSQL + " AND ";
            resultSQL = resultSQL + " AND ";
        }

        if (!StringUtils.isEmpty(apiUserEntity.getEmail())) {
            countSQL = countSQL + " (cellPhone LIKE ? OR email LIKE ?)";
            resultSQL = resultSQL + " (cellPhone LIKE ? OR email LIKE ?)";
            objectList.add("%" + apiUserEntity.getCellPhone() + "%");
            objectList.add("%" + apiUserEntity.getEmail() + "%");
        }

        resultSQL = resultSQL + " ORDER BY updateDateTime DESC ";
        resultSQL = resultSQL + " LIMIT ? , ? ";
        if (objectList.size() > 0) {
            jqPage.setRecords(jdbcTemplate.queryForObject(countSQL, objectList.toArray(), int.class));
            objectList.add(jqPage.getFromIndex());
            objectList.add(jqPage.getPageSize());
            jqPage.setRows(jdbcTemplate.query(resultSQL, objectList.toArray(), new ApiUserEntityRowMapper()));
        } else {
            jqPage.setRecords(jdbcTemplate.queryForObject(countSQL, int.class));
            Object[] args = {jqPage.getFromIndex(), jqPage.getPageSize()};
            jqPage.setRows(jdbcTemplate.query(resultSQL, args, new ApiUserEntityRowMapper()));
        }

        return jqPage;
    }

    @Override
    public void insertApiUserEntity(ApiUserEntity apiUserEntity) {
        apiUserMapper.insert(apiUserEntity);
    }

    @Override
    public void deleteApiUserEntity(Long userId) {
        apiUserMapper.delete(userId);
    }

    @Override
    public void updateApiUserEntity(Long userId, ApiUserEntity apiUserEntity) {
        apiUserEntity.setUserId(userId);
        apiUserMapper.update(apiUserEntity);
    }
}
