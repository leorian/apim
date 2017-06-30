package com.leorain.apim.sevice;

import com.leorain.apim.entity.InterfaceResponseEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface InterfaceResponseService {
    /**
     * 根据接口出参ID查询接口出参信息
     *
     * @param interfaceResponseId
     * @return
     */
    InterfaceResponseEntity findInterfaceResponseEntity(Long interfaceResponseId);

    /**
     * 查询所有接口出参信息列表
     *
     * @return
     */
    List<InterfaceResponseEntity> findInterfaceResponseEntityList();
}
