package com.leorain.apim.mapper;

import com.leorain.apim.entity.InterfaceHttpEntity;
import com.leorain.apim.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/11 0011.
 */
public interface InterfaceHttpMapper extends BaseMapper<InterfaceHttpEntity> {
    /**
     * @param appId
     * @return
     */
    List<InterfaceHttpEntity> getAllByAppId(@Param("appId") Long appId);
}
