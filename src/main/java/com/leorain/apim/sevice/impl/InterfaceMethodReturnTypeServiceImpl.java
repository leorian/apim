package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.InterfaceMethodReturnTypeEntity;
import com.leorain.apim.mapper.InterfaceMethodReturnTypeMapper;
import com.leorain.apim.sevice.InterfaceMethodReturnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class InterfaceMethodReturnTypeServiceImpl implements InterfaceMethodReturnTypeService {
    @Autowired
    private InterfaceMethodReturnTypeMapper interfaceMethodReturnTypeMapper;

    @Override
    public InterfaceMethodReturnTypeEntity findInterfaceMethodReturnTypeEntity(Long interfaceMethodReturnTypeId) {
        return interfaceMethodReturnTypeMapper.getOne(interfaceMethodReturnTypeId);
    }

    @Override
    public List<InterfaceMethodReturnTypeEntity> findInterfaceMethodReturnTypeEntityList() {
        return interfaceMethodReturnTypeMapper.getAll();
    }
}
