package com.leorain.apim.web;

import com.leorain.apim.entity.ApiUserEntity;
import com.leorain.apim.sevice.ApiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@RestController
@RequestMapping("/apiUser")
public class ApiUserController {
    @Autowired
    private ApiUserService apiUserService;

    /**
     * 根据用户ID查询用户信息
     *
     * @param userId
     * @return
     */
    @RequestMapping("/findApiUser/{userId}")
    public ApiUserEntity findApiUser(@PathVariable("userId") Long userId) {
        return apiUserService.findApiUserEntity(userId);
    }

    /**
     * 查询所有用户信息列表
     *
     * @return
     */
    @RequestMapping("/findApiUserList")
    public List<ApiUserEntity> findApiUserList() {
        return apiUserService.findApiUserEntityList();
    }
}
