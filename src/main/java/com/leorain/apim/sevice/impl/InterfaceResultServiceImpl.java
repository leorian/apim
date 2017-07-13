package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.InterfaceResultEntity;
import com.leorain.apim.enums.InterfaceTypeEnum;
import com.leorain.apim.mapper.InterfaceResultMapper;
import com.leorain.apim.sevice.InterfaceResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/12 0012.
 */
@Service
public class InterfaceResultServiceImpl implements InterfaceResultService {

    @Autowired
    private InterfaceResultMapper interfaceResultMapper;

    @Override
    public void insertInterfaceResultEntities(List<InterfaceResultEntity> interfaceResultEntities) {
        for (InterfaceResultEntity interfaceResultEntity : interfaceResultEntities) {
            interfaceResultMapper.insert(interfaceResultEntity);
        }
    }

    @Override
    public List<InterfaceResultEntity> findInterfaceEntitiesByInterfaceId(String interfaceId, InterfaceTypeEnum interfaceTypeEnum) {
        return interfaceResultMapper.getInterfaceResultEntitiesByInterfaceId(interfaceId, interfaceTypeEnum.name());
    }
}
