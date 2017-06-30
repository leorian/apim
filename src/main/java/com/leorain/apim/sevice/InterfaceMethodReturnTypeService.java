package com.leorain.apim.sevice;

import com.leorain.apim.entity.InterfaceMethodReturnTypeEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface InterfaceMethodReturnTypeService {

    /**
     * 根据interfaceMethodReturnTypeId查询接口方法返回值类型信息
     *
     * @param interfaceMethodReturnTypeId
     * @return
     */
    InterfaceMethodReturnTypeEntity findInterfaceMethodReturnTypeEntity(Long interfaceMethodReturnTypeId);

    /**
     * 查询所有接口方法返回值类型信息
     *
     * @return
     */
    List<InterfaceMethodReturnTypeEntity> findInterfaceMethodReturnTypeEntityList();
}
