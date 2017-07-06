package com.leorain.apim.sevice;

import com.leorain.apim.entity.ApiUserEntity;
import com.leorain.apim.tools.JqPage;

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

    /**
     * 分页查询
     *
     * @param jqPage
     * @param apiUserEntity
     * @return
     */
    JqPage<ApiUserEntity> findApiUserEntityPage(JqPage jqPage, ApiUserEntity apiUserEntity);

    /**
     * 新增用户
     *
     * @param apiUserEntity
     */
    void insertApiUserEntity(ApiUserEntity apiUserEntity);
}
