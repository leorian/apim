package com.leorain.apim.sevice;

import com.leorain.apim.entity.InterfaceResultEntity;
import com.leorain.apim.enums.InterfaceTypeEnum;

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

    /**
     * 查询接口返回示例
     *
     * @param interfaceId
     * @param interfaceTypeEnum
     * @return
     */
    List<InterfaceResultEntity> findInterfaceEntitiesByInterfaceId(String interfaceId, InterfaceTypeEnum interfaceTypeEnum);
}
