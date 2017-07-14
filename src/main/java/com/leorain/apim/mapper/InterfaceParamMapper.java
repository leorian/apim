package com.leorain.apim.mapper;

import com.leorain.apim.entity.InterfaceParamEntity;
import com.leorain.apim.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 接口DAO操作
 */
public interface InterfaceParamMapper extends BaseMapper<InterfaceParamEntity> {
    /**
     * @param interfaceId
     * @param interfaceType
     * @return
     */
    List<InterfaceParamEntity> getInterfaceParamEntitiesByInterfaceId(@Param("interfaceId") Long interfaceId,
                                                                      @Param("interfaceType") String interfaceType);

    /**
     * @param interfaceId
     * @param interfaceType
     */
    void deleteByInterfaceId(@Param("interfaceId") Long interfaceId,
                             @Param("interfaceType") String interfaceType);
}
