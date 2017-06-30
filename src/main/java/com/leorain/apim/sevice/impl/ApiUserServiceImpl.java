package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.ApiUserEntity;
import com.leorain.apim.mapper.ApiUserMapper;
import com.leorain.apim.sevice.ApiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class ApiUserServiceImpl implements ApiUserService {

    @Autowired
    private ApiUserMapper apiUserMapper;

    @Override
    public ApiUserEntity findApiUserEntity(Long userId) {
        return apiUserMapper.getOne(userId);
    }

    @Override
    public List<ApiUserEntity> findApiUserEntityList() {
        return apiUserMapper.getAll();
    }
}
