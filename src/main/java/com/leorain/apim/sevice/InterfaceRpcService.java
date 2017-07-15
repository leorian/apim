package com.leorain.apim.sevice;

import com.leorain.apim.entity.InterfaceRpcEntity;

import java.util.List;

/**
 * Created by xiezhonggui on 2017/7/15.
 */
public interface InterfaceRpcService {
    /**
     *
     * @param interfaceRpcEntity
     */
    void insertInterfaceRpcEntity(InterfaceRpcEntity interfaceRpcEntity);

    /**
     *
     * @param interfaceRpcEntity
     */
    void updateInterfaceRpcEntity(InterfaceRpcEntity interfaceRpcEntity);

    /**
     *
     * @return
     */
    List<InterfaceRpcEntity> findInterfaceRpcEntities();

    /**
     *
     * @param interfaceId
     * @return
     */
    InterfaceRpcEntity findInterfaceRpcEntity(Long interfaceId);

    /**
     *
     * @param interfaceId
     */
    void deleteInterfaceRpcEntity(Long interfaceId);
}
