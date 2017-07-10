package com.leorain.apim.mongodb.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/1/5 0005.
 */
public enum OperationType {
    ADD("新增"),
    UPDATE("更新"),
    DELETE("删除");
    private String value;

    OperationType(String value) {
        this.value = value;
    }

    public static Map<String, String> OPERATION_TYPE_MAP = new HashMap<>();

    static {
        for (OperationType operationType : EnumSet.allOf(OperationType.class)) {
            OPERATION_TYPE_MAP.put(operationType.name(), operationType.value);
        }
    }
}
