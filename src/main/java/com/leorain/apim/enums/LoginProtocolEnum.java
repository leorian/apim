package com.leorain.apim.enums;

import com.alibaba.fastjson.JSON;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/7/10 0010.
 */
public enum LoginProtocolEnum {
    SSH("SSH");
    public static final Map<String, String> DATA_MAP = new HashMap<>();

    static {
        for (LoginProtocolEnum loginProtocolEnum : EnumSet.allOf(LoginProtocolEnum.class)) {
            DATA_MAP.put(loginProtocolEnum.name(), loginProtocolEnum.getCode());
        }
    }

    LoginProtocolEnum(String code) {
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
