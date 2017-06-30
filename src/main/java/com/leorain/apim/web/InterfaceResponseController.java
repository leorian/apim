package com.leorain.apim.web;

import com.leorain.apim.entity.InterfaceResponseEntity;
import com.leorain.apim.sevice.InterfaceResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@RestController
@RequestMapping("/interfaceResponse")
public class InterfaceResponseController {

    @Autowired
    private InterfaceResponseService interfaceResponseService;

    /**
     * 根据接口出参ID查询接口出参信息
     *
     * @param interfaceResponseId
     * @return
     */
    @RequestMapping("/findInterfaceResponse/{interfaceResponseId}")
    public InterfaceResponseEntity findInterfaceResponse(@PathVariable("interfaceResponseId") Long interfaceResponseId) {
        return interfaceResponseService.findInterfaceResponseEntity(interfaceResponseId);
    }

    /**
     * 查询所有的接口出参信息列表
     *
     * @return
     */
    @RequestMapping("/findInterfaceResponseList")
    public List<InterfaceResponseEntity> findInterfaceResponseList() {
        return interfaceResponseService.findInterfaceResponseEntityList();
    }
}
