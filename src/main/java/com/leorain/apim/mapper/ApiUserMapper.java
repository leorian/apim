package com.leorain.apim.mapper;

import com.leorain.apim.entity.ApiUserEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 用户DAO操作
 */
public interface ApiUserMapper {
    List<ApiUserEntity> getAll();

    ApiUserEntity getOne(Long id);

    void insert(ApiUserEntity user);

    void update(ApiUserEntity user);

    void delete(Long id);
}
