package com.leorain.apim.sevice;

import com.leorain.apim.entity.InterfaceHttpEntity;

/**
 * Created by xiezg@317hu.com on 2017/7/11 0011.
 */
public interface InterfaceHttpService {
    /**
     * 新增HTTP接口
     *
     * @param interfaceHttpEntity
     */
    void insertInterfaceHttpEntity(InterfaceHttpEntity interfaceHttpEntity);
}
