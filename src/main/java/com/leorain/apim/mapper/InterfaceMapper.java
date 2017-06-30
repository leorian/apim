package com.leorain.apim.mapper;

import com.leorain.apim.entity.InterfaceEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 接口DAO操作
 */
public interface InterfaceMapper {
    List<InterfaceEntity> getAll();

    InterfaceEntity getOne(Long id);

    void insert(InterfaceEntity interfaceEntity);

    void update(InterfaceEntity interfaceEntity);

    void delete(Long id);
}
