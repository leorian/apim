package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.InterfaceRpcEntity;
import com.leorain.apim.mapper.InterfaceRpcMapper;
import com.leorain.apim.sevice.InterfaceRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by xiezhonggui on 2017/7/15.
 */
@Service
public class InterfaceRpcServiceImpl implements InterfaceRpcService {
    @Autowired
    private InterfaceRpcMapper interfaceRpcMapper;

    @Override
    public void insertInterfaceRpcEntity(InterfaceRpcEntity interfaceRpcEntity) {
        interfaceRpcMapper.insert(interfaceRpcEntity);
    }

    @Override
    public void updateInterfaceRpcEntity(InterfaceRpcEntity interfaceRpcEntity) {
        interfaceRpcMapper.update(interfaceRpcEntity);
    }

    @Override
    public List<InterfaceRpcEntity> findInterfaceRpcEntities() {
        List<InterfaceRpcEntity> interfaceRpcEntities = interfaceRpcMapper.getAll();
        if (!CollectionUtils.isEmpty(interfaceRpcEntities)) {
            for (InterfaceRpcEntity interfaceRpcEntity : interfaceRpcEntities) {
                interfaceRpcEntity.setIdText(String.valueOf(interfaceRpcEntity.getId()));
            }
        }
        return interfaceRpcEntities;
    }

    @Override
    public InterfaceRpcEntity findInterfaceRpcEntity(Long interfaceId) {
        return interfaceRpcMapper.getOne(interfaceId);
    }

    @Override
    public void deleteInterfaceRpcEntity(Long interfaceId) {
        interfaceRpcMapper.delete(interfaceId);
    }
}
