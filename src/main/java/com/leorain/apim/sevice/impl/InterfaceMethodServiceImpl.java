package com.leorain.apim.sevice.impl;

import com.leorain.apim.mapper.InterfaceMethodMapper;
import com.leorain.apim.sevice.InterfaceMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class InterfaceMethodServiceImpl implements InterfaceMethodService {

    @Autowired
    private InterfaceMethodMapper interfaceMethodMapper;
}