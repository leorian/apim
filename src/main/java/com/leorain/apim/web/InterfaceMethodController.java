package com.leorain.apim.web;

import com.leorain.apim.sevice.InterfaceMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@RestController
public class InterfaceMethodController {
    @Autowired
    private InterfaceMethodService interfaceMethodService;
}
