package com.leorain.apim.web;

import com.leorain.apim.domain.ApiUserDomain;
import com.leorain.apim.domain.ResultDomain;
import com.leorain.apim.entity.ApiUserEntity;
import com.leorain.apim.sevice.ApiUserService;
import com.leorain.apim.tools.JqPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 分页查询用户信息列表
     *
     * @return
     */
    @RequestMapping("/findApiUserPage")
    public JqPage<ApiUserEntity> findApiUserPage(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                 @RequestParam(value = "userNameCondition", required = false) String userNameCondition,
                                                 @RequestParam(value = "contactWayCondition", required = false) String contactWayCondition) {
        JqPage jqPage = new JqPage();
        jqPage.setPage(currentPage);
        jqPage.setPageSize(pageSize);
        ApiUserEntity apiUserEntity = new ApiUserEntity();
        apiUserEntity.setUsName(userNameCondition);
        apiUserEntity.setCnName(userNameCondition);
        apiUserEntity.setCellPhone(contactWayCondition);
        apiUserEntity.setEmail(contactWayCondition);
        return apiUserService.findApiUserEntityPage(jqPage, apiUserEntity);
    }

    /**
     * 新增用户
     *
     * @param apiUserDomain
     */
    @RequestMapping("/insertApiUser")
    public ResultDomain insertApiUser(ApiUserDomain apiUserDomain) {
        apiUserService.insertApiUserEntity(apiUserDomain.buildApiUserEntity());
        return new ResultDomain();
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @RequestMapping("/deleteApiUser")
    public ResultDomain deleteApiUser(@RequestParam("userId") Long userId) {
        apiUserService.deleteApiUserEntity(userId);
        return new ResultDomain();
    }

    /**
     * 更新用户
     *
     * @param apiUserDomain
     * @return
     */
    @RequestMapping("/updateApiUser")
    public ResultDomain updateApiUser(ApiUserDomain apiUserDomain, @RequestParam("userIdInput") Long userId) {
        apiUserService.updateApiUserEntity(userId, apiUserDomain.buildApiUserEntity());
        return new ResultDomain();
    }
}
