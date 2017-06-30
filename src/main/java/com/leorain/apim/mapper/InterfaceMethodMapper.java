package com.leorain.apim.mapper;

import com.leorain.apim.entity.InterfaceMethodEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 接口方法DAO操作
 */
public interface InterfaceMethodMapper {
    List<InterfaceMethodEntity> getAll();

    InterfaceMethodEntity getOne(Long id);

    void insert(InterfaceMethodEntity interfaceMethodEntity);

    void update(InterfaceMethodEntity interfaceMethodEntity);

    void delete(Long id);
}
