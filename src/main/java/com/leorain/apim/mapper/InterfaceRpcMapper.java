package com.leorain.apim.mapper;

import com.leorain.apim.entity.InterfaceRpcEntity;
import com.leorain.apim.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xiezhonggui on 2017/7/15.
 */
public interface InterfaceRpcMapper extends BaseMapper<InterfaceRpcEntity> {
    /**
     * @param appId
     * @return
     */
    List<InterfaceRpcEntity> getAllByAppId(@Param("appId") Long appId);
}
