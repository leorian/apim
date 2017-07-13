package com.leorain.apim.mapper;

import com.leorain.apim.entity.InterfaceResultEntity;
import com.leorain.apim.enums.InterfaceTypeEnum;
import com.leorain.apim.mapper.base.BaseMapper;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/12 0012.
 */
public interface InterfaceResultMapper extends BaseMapper<InterfaceResultEntity> {
    /**
     * @param interfaceId
     * @param interfaceType
     * @return
     */
    List<InterfaceResultEntity> getInterfaceResultEntitiesByInterfaceId(String interfaceId, String interfaceType);
}
