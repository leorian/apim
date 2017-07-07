package com.leorain.apim.enums;

import com.alibaba.fastjson.JSON;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/7/7 0007.
 */
public enum EnvEnum {
    DEV("开发"),
    SIT("测试"),
    UAT("预发"),
    PRD("线上");

    public static Map<String, String> DATA_MAP = new HashMap<>();

    static {
        for (EnvEnum envEnum : EnumSet.allOf(EnvEnum.class)) {
            DATA_MAP.put(envEnum.name(), envEnum.getCode());
        }
    }

    EnvEnum(String code) {
        this.code = code;
    }

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
