package com.leorain.apim.sevice;

import com.leorain.apim.entity.InterfaceMethodReturnTypeEntity;
import com.leorain.apim.tools.JqPage;

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

    /**
     * 分页查询
     *
     * @param jqPage
     * @param interfaceMethodReturnTypeEntity
     * @return
     */
    JqPage<InterfaceMethodReturnTypeEntity> findInterfaceMethodReturnTypeEntityPage(JqPage jqPage,
                                                                                    InterfaceMethodReturnTypeEntity interfaceMethodReturnTypeEntity);
}
