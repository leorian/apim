package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.InterfaceEntity;
import com.leorain.apim.mapper.InterfaceMapper;
import com.leorain.apim.sevice.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class InterfaceServiceImpl implements InterfaceService {
    @Autowired
    private InterfaceMapper interfaceMapper;

    @Override
    public InterfaceEntity findInterfaceEntity(Long interfaceId) {
        return interfaceMapper.getOne(interfaceId);
    }

    @Override
    public List<InterfaceEntity> findInterfaceEntityList() {
        return interfaceMapper.getAll();
    }
}
