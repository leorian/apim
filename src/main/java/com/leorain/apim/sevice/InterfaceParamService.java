package com.leorain.apim.sevice;

import com.leorain.apim.entity.InterfaceParamEntity;

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
}
