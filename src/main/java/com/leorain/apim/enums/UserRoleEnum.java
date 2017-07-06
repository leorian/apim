package com.leorain.apim.enums;

import com.alibaba.fastjson.JSON;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/7/6 0006.
 */
public enum UserRoleEnum {
    SystemManager(1, "系统管理员"),
    DeveloperMan(2, "开发人员"),
    TesterMan(3, "测试人员"),
    OperatorMan(4, "运维人员"),
    ProductMan(5, "产品人员");

    public static final Map<Integer, String> DATA_MAP = new HashMap<>();

    static {
        for (UserRoleEnum userRoleEnum : EnumSet.allOf(UserRoleEnum.class)) {
            DATA_MAP.put(userRoleEnum.getCode(), userRoleEnum.getName());
        }
    }

    UserRoleEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private Integer code;
    private String name;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
