package com.leorain.apim.web;

import com.leorain.apim.entity.InterfaceMethodReturnTypeEntity;
import com.leorain.apim.sevice.InterfaceMethodReturnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@RestController
@RequestMapping("/interfaceMethodReturnType")
public class InterfaceMethodReturnTypeController {
    @Autowired
    private InterfaceMethodReturnTypeService interfaceMethodReturnTypeService;

    /**
     * 根据接口方法返回值类型ID查询接口方法返回值类型信息
     *
     * @param interfaceMethodReturnTypeId
     * @return
     */
    @RequestMapping("/findInterfaceMethodReturnType/{interfaceMethodReturnTypeId}")
    InterfaceMethodReturnTypeEntity findInterfaceMethodReturnType(@PathVariable("interfaceMethodReturnTypeId")
                                                                          Long interfaceMethodReturnTypeId) {
        return interfaceMethodReturnTypeService.findInterfaceMethodReturnTypeEntity(interfaceMethodReturnTypeId);
    }

    /**
     * 查询所有的接口方法返回值类型信息列表
     *
     * @return
     */
    @RequestMapping("/findInterfaceMethodReturnTypeList")
    List<InterfaceMethodReturnTypeEntity> findInterfaceMethodReturnTypeList() {
        return interfaceMethodReturnTypeService.findInterfaceMethodReturnTypeEntityList();
    }
}
