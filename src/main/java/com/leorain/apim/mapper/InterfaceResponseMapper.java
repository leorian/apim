package com.leorain.apim.mapper;

import com.leorain.apim.entity.InterfaceResponseEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface InterfaceResponseMapper {
    List<InterfaceResponseEntity> getAll();

    InterfaceResponseEntity getOne(Long id);

    void insert(InterfaceResponseEntity interfaceResponseEntity);

    void update(InterfaceResponseEntity interfaceResponseEntity);

    void delete(Long id);
}
