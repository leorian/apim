package com.leorain.apim.web;

import com.alibaba.fastjson.JSON;
import com.leorain.apim.domain.InterfaceHttpDomain;
import com.leorain.apim.domain.ResultDomain;
import com.leorain.apim.entity.InterfaceHttpEntity;
import com.leorain.apim.entity.InterfaceParamEntity;
import com.leorain.apim.entity.InterfaceResultEntity;
import com.leorain.apim.enums.InterfaceTypeEnum;
import com.leorain.apim.sevice.InterfaceHttpService;
import com.leorain.apim.sevice.InterfaceParamService;
import com.leorain.apim.sevice.InterfaceResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/12 0012.
 */
@RestController
@RequestMapping("/interfaceHttp")
public class InterfaceHttpController {

    @Autowired
    private InterfaceHttpService interfaceHttpService;

    @Autowired
    private InterfaceParamService interfaceParamService;

    @Autowired
    private InterfaceResultService interfaceResultService;


    /**
     * @param interfaceHttpDomain
     * @return
     */
    @RequestMapping(value = "/insertInterfaceHttp", method = RequestMethod.POST)
    public ResultDomain insertInterfaceHttp(InterfaceHttpDomain interfaceHttpDomain) {
        System.out.println(JSON.toJSONString(interfaceHttpDomain));
        InterfaceHttpEntity interfaceHttpEntity = interfaceHttpDomain.buildInterfaceHttpEntity();
        interfaceHttpService.insertInterfaceHttpEntity(interfaceHttpEntity);
        List<InterfaceParamEntity> interfaceParamEntities = interfaceHttpDomain.
                buildInterfaceParamEntities(interfaceHttpEntity.getId());
        interfaceParamService.insertInterfaceParamEntities(interfaceParamEntities);
        List<InterfaceResultEntity> interfaceResultEntities = interfaceHttpDomain.
                buildInterfaceResultEntities(interfaceHttpEntity.getId());
        interfaceResultService.insertInterfaceResultEntities(interfaceResultEntities);
        return new ResultDomain();
    }

    /**
     * @return
     */
    @RequestMapping("/findInterfaceHttpList")
    public List<InterfaceHttpEntity> findInterfaceHttpList() {
        return interfaceHttpService.findInterfaceHttpEntities();
    }

    /**
     * @param interfaceId
     * @return
     */
    @RequestMapping("/findInterface/{interfaceId}")
    public InterfaceHttpEntity findInterfaceHttp(@RequestParam("interfaceId") Long interfaceId) {
        InterfaceHttpEntity interfaceHttpEntity = interfaceHttpService.findInterfaceHttpEntity(interfaceId);
        interfaceHttpEntity.setInterfaceParamEntities(interfaceParamService.
                findInterfaceParamEntityByInterfaceId(interfaceHttpEntity.getId(), InterfaceTypeEnum.HTTP));
        interfaceHttpEntity.setInterfaceResultEntities(interfaceResultService.
                findInterfaceResultEntitiesByInterfaceId(interfaceHttpEntity.getId(),
                        InterfaceTypeEnum.HTTP));

        return interfaceHttpEntity;
    }
}
