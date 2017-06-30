package com.leorain.apim.web;

import com.leorain.apim.entity.InterfaceMethodParameterEntity;
import com.leorain.apim.sevice.InterfaceMethodParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@RestController
@RequestMapping("/interfaceMethodParameter")
public class InterfaceMethodParameterController {
    @Autowired
    private InterfaceMethodParameterService interfaceMethodParameterService;

    /**
     * 根据接口方法参数ID查询接口方法信息
     *
     * @param interfaceMethodParameterId
     * @return
     */
    @RequestMapping("/findInterfaceMethodParameter/{interfaceMethodParameterId}")
    public InterfaceMethodParameterEntity findInterfaceMethodParameter(@PathVariable("interfaceMethodParameterId") Long interfaceMethodParameterId) {
        return interfaceMethodParameterService.findInterfaceMethodParameterEntity(interfaceMethodParameterId);
    }

    /**
     * 查询所有的接口方法参数信息列表
     *
     * @return
     */
    @RequestMapping("/findInterfaceMethodParameterList")
    public List<InterfaceMethodParameterEntity> findInterfaceMethodParameterList() {
        return interfaceMethodParameterService.findInterfaceMethodParameterEntityList();
    }
}
