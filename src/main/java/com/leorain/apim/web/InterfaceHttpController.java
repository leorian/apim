package com.leorain.apim.web;

import com.alibaba.fastjson.JSON;
import com.leorain.apim.domain.InterfaceHttpDomain;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiezg@317hu.com on 2017/7/12 0012.
 */
@RestController
@RequestMapping("/interfaceHttp")
public class InterfaceHttpController {

    @RequestMapping(value = "/insertInterfaceHttp", method = RequestMethod.POST)
    public String insertInterfaceHttp(InterfaceHttpDomain interfaceHttpDomain) {
        System.out.println(JSON.toJSONString(interfaceHttpDomain));
        return "String";
    }
}
