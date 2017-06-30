package com.leorain.apim.web;

import com.leorain.apim.entity.InterfaceEntity;
import com.leorain.apim.sevice.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@RestController
@RequestMapping("/interface")
public class InterfaceController {
    @Autowired
    private InterfaceService interfaceService;

    /**
     * 根据接口ID查询接口信息
     *
     * @param interfaceId
     * @return
     */
    @RequestMapping("/findInterface/{interfaceId}")
    public InterfaceEntity findInterface(@PathVariable("interfaceId") Long interfaceId) {
        return interfaceService.findInterfaceEntity(interfaceId);
    }

    /**
     * 查询所有接口信息
     *
     * @return
     */
    @RequestMapping("/findInterfaceList")
    public List<InterfaceEntity> findInterfaceList() {
        return interfaceService.findInterfaceEntityList();
    }
}
