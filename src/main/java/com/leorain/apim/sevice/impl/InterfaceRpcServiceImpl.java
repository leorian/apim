package com.leorain.apim.sevice.impl;

import com.leorain.apim.mapper.InterfaceRpcMapper;
import com.leorain.apim.sevice.InterfaceRpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by xiezhonggui on 2017/7/15.
 */
public class InterfaceRpcServiceImpl implements InterfaceRpcService {
    @Autowired
    private InterfaceRpcMapper interfaceRpcMapper;
}
