package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.InterfaceMethodParameterEntity;
import com.leorain.apim.mapper.InterfaceMethodParameterMapper;
import com.leorain.apim.sevice.InterfaceMethodParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class InterfaceMethodParameterServiceImpl implements InterfaceMethodParameterService {

    @Autowired
    private InterfaceMethodParameterMapper interfaceMethodParameterMapper;

    @Override
    public InterfaceMethodParameterEntity findInterfaceMethodParameterEntity(Long interfaceMethodParameterId) {
        return interfaceMethodParameterMapper.getOne(interfaceMethodParameterId);
    }

    @Override
    public List<InterfaceMethodParameterEntity> findInterfaceMethodParameterEntityList() {
        return interfaceMethodParameterMapper.getAll();
    }
}
