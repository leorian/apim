package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.InterfaceRequestEntity;
import com.leorain.apim.mapper.InterfaceRequestMapper;
import com.leorain.apim.sevice.InterfaceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class InterfaceRequestServiceImpl implements InterfaceRequestService {
    @Autowired
    private InterfaceRequestMapper interfaceRequestMapper;

    @Override
    public InterfaceRequestEntity findInterfaceRequestEntity(Long interfaceRequestId) {
        return interfaceRequestMapper.getOne(interfaceRequestId);
    }

    @Override
    public List<InterfaceRequestEntity> findInterfaceRequestEntityList() {
        return interfaceRequestMapper.getAll();
    }
}
