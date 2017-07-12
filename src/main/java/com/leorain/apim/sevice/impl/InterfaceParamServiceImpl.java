package com.leorain.apim.sevice.impl;

import com.leorain.apim.mapper.InterfaceParamMapper;
import com.leorain.apim.sevice.InterfaceParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiezg@317hu.com on 2017/7/12 0012.
 */
@Service
public class InterfaceParamServiceImpl implements InterfaceParamService {

    @Autowired
    private InterfaceParamMapper interfaceParamMapper;
}
