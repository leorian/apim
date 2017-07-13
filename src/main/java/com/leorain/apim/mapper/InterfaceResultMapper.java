package com.leorain.apim.mapper;

import com.leorain.apim.entity.InterfaceResultEntity;
import com.leorain.apim.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

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
    List<InterfaceResultEntity> getInterfaceResultEntitiesByInterfaceId(@Param("interfaceId") Long interfaceId,
                                                                        @Param("interfaceType") String interfaceType);
}
