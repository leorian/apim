package com.leorain.apim.web;

import com.leorain.apim.sevice.InterfaceResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@RestController
@RequestMapping("/interfaceResponse")
public class InterfaceResponseController {

    @Autowired
    private InterfaceResponseService interfaceResponseService;
}
