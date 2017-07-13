package com.leorain.apim.sevice;

import com.leorain.apim.entity.InterfaceResultEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/12 0012.
 */
public interface InterfaceResultService {
    /**
     * 插入接口结果示例
     *
     * @param interfaceResultEntities
     */
    void insertInterfaceResultEntities(List<InterfaceResultEntity> interfaceResultEntities);
}
