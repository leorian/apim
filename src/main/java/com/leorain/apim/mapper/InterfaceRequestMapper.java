package com.leorain.apim.mapper;

import com.leorain.apim.entity.InterfaceRequestEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface InterfaceRequestMapper {
    List<InterfaceRequestEntity> getAll();

    InterfaceRequestEntity getOne(Long id);

    void insert(InterfaceRequestEntity interfaceRequestEntity);

    void update(InterfaceRequestEntity interfaceRequestEntity);

    void delete(Long id);
}
