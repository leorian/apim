package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.InterfaceHttpEntity;
import com.leorain.apim.mapper.InterfaceHttpMapper;
import com.leorain.apim.sevice.InterfaceHttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/11 0011.
 */
@Service
public class InterfaceHttpServiceImpl implements InterfaceHttpService {
    @Autowired
    private InterfaceHttpMapper interfaceHttpMapper;

    @Override
    public void insertInterfaceHttpEntity(InterfaceHttpEntity interfaceHttpEntity) {
        interfaceHttpMapper.insert(interfaceHttpEntity);
    }

    @Override
    public List<InterfaceHttpEntity> findInterfaceHttpEntities() {
        List<InterfaceHttpEntity> interfaceHttpEntities = interfaceHttpMapper.getAll();
        if (!CollectionUtils.isEmpty(interfaceHttpEntities)) {
            for (InterfaceHttpEntity interfaceHttpEntity : interfaceHttpEntities) {
                interfaceHttpEntity.setIdText(String.valueOf(interfaceHttpEntity.getId()));
            }
        }
        return interfaceHttpEntities;
    }

    @Override
    public InterfaceHttpEntity findInterfaceHttpEntity(Long interfaceId) {
        return interfaceHttpMapper.getOne(interfaceId);
    }
}
