package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.InterfaceResponseEntity;
import com.leorain.apim.mapper.InterfaceResponseMapper;
import com.leorain.apim.sevice.InterfaceResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class InterfaceResponseServiceImpl implements InterfaceResponseService {
    @Autowired
    private InterfaceResponseMapper interfaceResponseMapper;

    @Override
    public InterfaceResponseEntity findInterfaceResponseEntity(Long interfaceResponseId) {
        return interfaceResponseMapper.getOne(interfaceResponseId);
    }

    @Override
    public List<InterfaceResponseEntity> findInterfaceResponseEntityList() {
        return interfaceResponseMapper.getAll();
    }
}
