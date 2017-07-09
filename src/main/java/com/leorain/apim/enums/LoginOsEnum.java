package com.leorain.apim.enums;

import com.alibaba.fastjson.JSON;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/7/10 0010.
 */
public enum LoginOsEnum {
    WIN("Windows"),
    Linux("Linux"),
    Mac("MacOS");

    public static final Map<String, String> DATA_MAP = new HashMap<>();

    static {
        for (LoginOsEnum loginOsEnum : EnumSet.allOf(LoginOsEnum.class)) {
            DATA_MAP.put(loginOsEnum.name(), loginOsEnum.getCode());
        }
    }

    LoginOsEnum(String code) {
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

