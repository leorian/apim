package com.leorain.apim.sevice;

import com.leorain.apim.entity.UserEntity;
import com.leorain.apim.tools.JqPage;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface UserService {
    /**
     * 分页查询
     *
     * @param jqPage
     * @param userEntity
     * @return
     */
    JqPage<UserEntity> findUserEntityPage(JqPage<UserEntity> jqPage, UserEntity userEntity);
}
