package com.leorain.apim.web;

import com.leorain.apim.entity.InterfaceRequestEntity;
import com.leorain.apim.sevice.InterfaceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@RestController
@RequestMapping("/interfaceRequest")
public class InterfaceRequestController {

    @Autowired
    private InterfaceRequestService interfaceRequestService;

    /**
     * 根据接口入参ID查询接口入参信息
     *
     * @param interfaceRequestId
     * @return
     */
    @RequestMapping("/findInterfaceRequest/{interfaceRequestId}")
    public InterfaceRequestEntity findInterfaceRequest(@PathVariable("interfaceRequestId") Long interfaceRequestId) {
        return interfaceRequestService.findInterfaceRequestEntity(interfaceRequestId);
    }

    /**
     * 查询所有的接口入参信息列表
     *
     * @return
     */
    @RequestMapping("/findInterfaceRequestList")
    public List<InterfaceRequestEntity> findInterfaceRequestList() {
        return interfaceRequestService.findInterfaceRequestEntityList();
    }
}
