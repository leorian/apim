package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.InterfaceParamEntity;
import com.leorain.apim.enums.InterfaceTypeEnum;
import com.leorain.apim.mapper.InterfaceParamMapper;
import com.leorain.apim.sevice.InterfaceParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/12 0012.
 */
@Service
public class InterfaceParamServiceImpl implements InterfaceParamService {

    @Autowired
    private InterfaceParamMapper interfaceParamMapper;

    @Override
    public void insertInterfaceParamEntities(List<InterfaceParamEntity> interfaceParamEntities) {
        for (InterfaceParamEntity interfaceParamEntity : interfaceParamEntities) {
            interfaceParamMapper.insert(interfaceParamEntity);
        }
    }

    @Override
    public List<InterfaceParamEntity> findInterfaceParamEntityByInterfaceId(Long interfaceId,
                                                                            InterfaceTypeEnum interfaceTypeEnum) {
        return interfaceParamMapper.getInterfaceParamEntitiesByInterfaceId(interfaceId, interfaceTypeEnum.name());
    }

    @Override
    public void deleteInterfaceParamEntityByInterfaceId(Long interfaceId, InterfaceTypeEnum interfaceTypeEnum) {
        interfaceParamMapper.deleteByInterfaceId(interfaceId, interfaceTypeEnum.name());
    }
}
