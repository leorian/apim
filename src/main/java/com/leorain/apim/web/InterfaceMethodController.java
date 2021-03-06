package com.leorain.apim.web;

import com.leorain.apim.entity.InterfaceMethodEntity;
import com.leorain.apim.sevice.InterfaceMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@RestController
@RequestMapping("/interfaceMethod")
public class InterfaceMethodController {
    @Autowired
    private InterfaceMethodService interfaceMethodService;

    /**
     * 根据接口方法ID查询接口方法信息
     *
     * @param interfaceMethodId
     * @return
     */
    @RequestMapping("/findInterfaceMethod/{interfaceMethodId}")
    public InterfaceMethodEntity findInterfaceMethod(@PathVariable("interfaceMethodId") Long interfaceMethodId) {
        return interfaceMethodService.findInterfaceMethodEntity(interfaceMethodId);
    }


    /**
     * 查询所有接口方法信息列表
     *
     * @return
     */
    @RequestMapping("/findInterfaceMethodList")
    public List<InterfaceMethodEntity> findInterfaceMethodList() {
        return interfaceMethodService.findInterfaceMethodEntityList();
    }
}
