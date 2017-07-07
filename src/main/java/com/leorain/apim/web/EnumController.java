package com.leorain.apim.web;

import com.leorain.apim.enums.EnvEnum;
import com.leorain.apim.enums.UserRoleEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/7/6 0006.
 */
@RestController
@RequestMapping("/enum")
public class EnumController {

    /**
     * 用户角色枚举
     *
     * @return
     */
    @RequestMapping("/userRoleEnums")
    public Map<Integer, String> userRoleEnums() {
        return UserRoleEnum.DATA_MAP;
    }

    /**
     * 环境枚举
     *
     * @return
     */
    @RequestMapping("/envEnums")
    public Map<String, String> envEnums() {
        return EnvEnum.DATA_MAP;
    }
}
