package com.leorain.apim.sevice;

import com.leorain.apim.entity.InterfaceMethodEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface InterfaceMethodService {
    /**
     * 根据接口方法ID查询接口方法信息
     *
     * @param interfaceMethodId
     * @return
     */
    InterfaceMethodEntity findInterfaceMethodEntity(Long interfaceMethodId);

    /**
     * 查询所有的接口方法信息列表
     *
     * @return
     */
    List<InterfaceMethodEntity> findInterfaceMethodEntityList();
}
