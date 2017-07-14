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
import org.springframework.web.bind.annotation.*;

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
     * @param interfaceHttpDomain
     * @param interfaceId
     * @return
     */
    @RequestMapping(value = "/updateInterfaceHttp", method = RequestMethod.POST)
    public ResultDomain updateInterfaceHttp(InterfaceHttpDomain interfaceHttpDomain,
                                            @RequestParam("interfaceHttpIdInput") Long interfaceId) {
        System.out.println(JSON.toJSONString(interfaceHttpDomain));
        InterfaceHttpEntity interfaceHttpEntity = interfaceHttpDomain.buildInterfaceHttpEntity();
        interfaceHttpEntity.setId(interfaceId);
        interfaceHttpService.updateInterfaceHttpEntity(interfaceHttpEntity);
        interfaceParamService.deleteInterfaceParamEntityByInterfaceId(interfaceId, InterfaceTypeEnum.HTTP);
        interfaceParamService.insertInterfaceParamEntities(interfaceHttpDomain.buildInterfaceParamEntities(interfaceId));
        interfaceResultService.deleteInterfaceResultEntityByInterfaceId(interfaceId, InterfaceTypeEnum.HTTP);
        interfaceResultService.insertInterfaceResultEntities(interfaceHttpDomain.buildInterfaceResultEntities(interfaceId));
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
    @RequestMapping("/findInterfaceHttp/{interfaceId}")
    public InterfaceHttpEntity findInterfaceHttp(@PathVariable("interfaceId") Long interfaceId) {
        InterfaceHttpEntity interfaceHttpEntity = interfaceHttpService.findInterfaceHttpEntity(interfaceId);
        interfaceHttpEntity.setInterfaceParamEntities(interfaceParamService.
                findInterfaceParamEntityByInterfaceId(interfaceHttpEntity.getId(), InterfaceTypeEnum.HTTP));
        interfaceHttpEntity.setInterfaceResultEntities(interfaceResultService.
                findInterfaceResultEntitiesByInterfaceId(interfaceHttpEntity.getId(),
                        InterfaceTypeEnum.HTTP));

        return interfaceHttpEntity;
    }

    /**
     * 删除接口信息
     *
     * @param interfaceId
     * @return
     */
    @RequestMapping("/deleteInterfaceHttp/{interfaceId}")
    public ResultDomain deleteInterfaceHttp(@PathVariable("interfaceId") Long interfaceId) {
        interfaceResultService.deleteInterfaceResultEntityByInterfaceId(interfaceId, InterfaceTypeEnum.HTTP);
        interfaceParamService.deleteInterfaceParamEntityByInterfaceId(interfaceId, InterfaceTypeEnum.HTTP);
        interfaceHttpService.deleteInterfaceHttpEntity(interfaceId);
        return new ResultDomain();
    }
}
