package com.leorain.apim.mapper;

import com.leorain.apim.entity.InterfaceMethodParameterEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 接口方法参数DAO操作
 */
public interface InterfaceMethodParameterMapper {
    List<InterfaceMethodParameterEntity> getAll();

    InterfaceMethodParameterEntity getOne(Long id);

    void insert(InterfaceMethodParameterEntity interfaceMethodParameterEntity);

    void update(InterfaceMethodParameterEntity interfaceMethodParameterEntity);

    void delete(Long id);
}
