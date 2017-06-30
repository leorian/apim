package com.leorain.apim.sevice;

import com.leorain.apim.entity.InterfaceRequestEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface InterfaceRequestService {
    /**
     * 根据接口入参ID查询接口请求参数信息
     *
     * @param interfaceRequestId
     * @return
     */
    InterfaceRequestEntity findInterfaceRequestEntity(Long interfaceRequestId);

    /**
     * 查询所有的接口入参请求参数信息
     *
     * @return
     */
    List<InterfaceRequestEntity> findInterfaceRequestEntityList();
}
