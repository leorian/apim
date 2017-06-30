package com.leorain.apim.sevice;

import com.leorain.apim.entity.InterfaceMethodParameterEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface InterfaceMethodParameterService {

    /**
     * 根据接口方法参数ID
     * @param interfaceMethodParameterId
     * @return
     */
    InterfaceMethodParameterEntity findInterfaceMethodParameterEntity(Long interfaceMethodParameterId);

    /**
     * 查询所有的接口方法参数列表
     * @return
     */
    List<InterfaceMethodParameterEntity> findInterfaceMethodParameterEntityList();
}
