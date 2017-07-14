package com.leorain.apim.sevice;

import com.leorain.apim.entity.InterfaceParamEntity;
import com.leorain.apim.enums.InterfaceTypeEnum;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/12 0012.
 */
public interface InterfaceParamService {

    /**
     * 插入接口参数
     *
     * @param interfaceParamEntities
     */
    void insertInterfaceParamEntities(List<InterfaceParamEntity> interfaceParamEntities);

    /**
     * 查询接口参数信息列表
     *
     * @param interfaceId
     * @param interfaceTypeEnum
     * @return
     */
    List<InterfaceParamEntity> findInterfaceParamEntityByInterfaceId(Long interfaceId, InterfaceTypeEnum interfaceTypeEnum);

    /**
     * @param interfaceId
     * @param interfaceTypeEnum
     */
    void deleteInterfaceParamEntityByInterfaceId(String interfaceId, InterfaceTypeEnum interfaceTypeEnum);
}
