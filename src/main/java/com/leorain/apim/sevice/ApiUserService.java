package com.leorain.apim.sevice;

import com.leorain.apim.entity.ApiUserEntity;

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
}
