package com.leorain.apim.web;

import com.alibaba.fastjson.JSON;
import com.leorain.apim.domain.InterfaceRpcDomain;
import com.leorain.apim.domain.ResultDomain;
import com.leorain.apim.entity.InterfaceParamEntity;
import com.leorain.apim.entity.InterfaceResultEntity;
import com.leorain.apim.entity.InterfaceRpcEntity;
import com.leorain.apim.enums.InterfaceTypeEnum;
import com.leorain.apim.sevice.InterfaceParamService;
import com.leorain.apim.sevice.InterfaceResultService;
import com.leorain.apim.sevice.InterfaceRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/12 0012.
 */
@RestController
@RequestMapping("/interfaceRpc")
public class InterfaceRpcController {

    @Autowired
    private InterfaceRpcService interfaceRpcService;

    @Autowired
    private InterfaceParamService interfaceParamService;

    @Autowired
    private InterfaceResultService interfaceResultService;


    /**
     * @param interfaceRpcDomain
     * @return
     */
    @RequestMapping(value = "/insertInterfaceRpc", method = RequestMethod.POST)
    public ResultDomain insertInterfaceRpc(InterfaceRpcDomain interfaceRpcDomain) {
        System.out.println(JSON.toJSONString(interfaceRpcDomain));
        InterfaceRpcEntity interfaceRpcEntity = interfaceRpcDomain.buildInterfaceRpcEntity();
        interfaceRpcService.insertInterfaceRpcEntity(interfaceRpcEntity);
        List<InterfaceParamEntity> interfaceParamEntities = interfaceRpcDomain.
                buildInterfaceParamEntities(interfaceRpcEntity.getId());
        interfaceParamService.insertInterfaceParamEntities(interfaceParamEntities);
        List<InterfaceResultEntity> interfaceResultEntities = interfaceRpcDomain.
                buildInterfaceResultEntities(interfaceRpcEntity.getId());
        interfaceResultService.insertInterfaceResultEntities(interfaceResultEntities);
        return new ResultDomain();
    }

    /**
     * @param interfaceRpcDomain
     * @param interfaceId
     * @return
     */
    @RequestMapping(value = "/updateInterfaceRpc", method = RequestMethod.POST)
    public ResultDomain updateInterfaceRpc(InterfaceRpcDomain interfaceRpcDomain,
                                            @RequestParam("interfaceRpcIdInput") Long interfaceId) {
        System.out.println(JSON.toJSONString(interfaceRpcDomain));
        InterfaceRpcEntity interfaceRpcEntity = interfaceRpcDomain.buildInterfaceRpcEntity();
        interfaceRpcEntity.setId(interfaceId);
        interfaceRpcService.updateInterfaceRpcEntity(interfaceRpcEntity);
        interfaceParamService.deleteInterfaceParamEntityByInterfaceId(interfaceId, InterfaceTypeEnum.RPC);
        interfaceParamService.insertInterfaceParamEntities(interfaceRpcDomain.buildInterfaceParamEntities(interfaceId));
        interfaceResultService.deleteInterfaceResultEntityByInterfaceId(interfaceId, InterfaceTypeEnum.RPC);
        interfaceResultService.insertInterfaceResultEntities(interfaceRpcDomain.buildInterfaceResultEntities(interfaceId));
        return new ResultDomain();
    }

    /**
     * @return
     */
    @RequestMapping("/findInterfaceRpcList")
    public List<InterfaceRpcEntity> findInterfaceRpcList() {
        return interfaceRpcService.findInterfaceRpcEntities();
    }

    /**
     * @param interfaceId
     * @return
     */
    @RequestMapping("/findInterfaceRpc/{interfaceId}")
    public InterfaceRpcEntity findInterfaceRpc(@PathVariable("interfaceId") Long interfaceId) {
        InterfaceRpcEntity interfaceRpcEntity = interfaceRpcService.findInterfaceRpcEntity(interfaceId);
        interfaceRpcEntity.setInterfaceParamEntities(interfaceParamService.
                findInterfaceParamEntityByInterfaceId(interfaceRpcEntity.getId(), InterfaceTypeEnum.RPC));
        interfaceRpcEntity.setInterfaceResultEntities(interfaceResultService.
                findInterfaceResultEntitiesByInterfaceId(interfaceRpcEntity.getId(),
                        InterfaceTypeEnum.RPC));

        return interfaceRpcEntity;
    }

    /**
     * 删除接口信息
     *
     * @param interfaceId
     * @return
     */
    @RequestMapping("/deleteInterfaceRpc/{interfaceId}")
    public ResultDomain deleteInterfaceRpc(@PathVariable("interfaceId") Long interfaceId) {
        interfaceResultService.deleteInterfaceResultEntityByInterfaceId(interfaceId, InterfaceTypeEnum.RPC);
        interfaceParamService.deleteInterfaceParamEntityByInterfaceId(interfaceId, InterfaceTypeEnum.RPC);
        interfaceRpcService.deleteInterfaceRpcEntity(interfaceId);
        return new ResultDomain();
    }
}
