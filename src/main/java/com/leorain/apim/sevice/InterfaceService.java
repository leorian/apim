package com.leorain.apim.sevice;

import com.leorain.apim.entity.InterfaceEntity;
import com.leorain.apim.tools.JqPage;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface InterfaceService {

    /**
     * 根据接口ID查询接口信息
     *
     * @param interfaceId
     * @return
     */
    InterfaceEntity findInterfaceEntity(Long interfaceId);

    /**
     * 查询所有接口信息
     *
     * @return
     */
    List<InterfaceEntity> findInterfaceEntityList();

    /**
     * 分页查询
     *
     * @param jqPage
     * @param interfaceEntity
     * @return
     */
    JqPage<InterfaceEntity> findInterfaceEntityPage(JqPage jqPage, InterfaceEntity interfaceEntity);
}
