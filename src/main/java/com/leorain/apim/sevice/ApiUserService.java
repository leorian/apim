package com.leorain.apim.sevice;

import com.leorain.apim.entity.ApiUserEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface ApiUserService {
    /**
     * 根据用户ID查询用户信息
     *
     * @param userId
     * @return
     */
    ApiUserEntity findApiUserEntity(Long userId);

    /**
     * 查询所有用户列表
     *
     * @return
     */
    List<ApiUserEntity> findApiUserEntityList();
}
