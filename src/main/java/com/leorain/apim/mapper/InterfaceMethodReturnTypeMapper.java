package com.leorain.apim.mapper;

import com.leorain.apim.entity.InterfaceMethodReturnTypeEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 接口方法返回值类型DAO操作
 */
public interface InterfaceMethodReturnTypeMapper {
    List<InterfaceMethodReturnTypeEntity> getAll();

    InterfaceMethodReturnTypeEntity getOne(Long id);

    void insert(InterfaceMethodReturnTypeEntity interfaceMethodReturnTypeEntity);

    void update(InterfaceMethodReturnTypeEntity interfaceMethodReturnTypeEntity);

    void delete(Long id);
}
