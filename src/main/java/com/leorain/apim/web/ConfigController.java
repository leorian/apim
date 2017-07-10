package com.leorain.apim.web;

import com.google.gson.Gson;
import com.leorain.apim.mongodb.consts.ConfigConstants;
import com.leorain.apim.mongodb.domain.ConfigSet;
import com.leorain.apim.mongodb.domain.DefineConfigSet;
import com.leorain.apim.mongodb.service.ConfigSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiezg@317hu.com on 2017/7/10 0010.
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    private ConfigSetService configSetService;

    @RequestMapping(value = "/getAllConfigSetList", method = RequestMethod.POST)
    public String getAllConfigSetList(HttpServletRequest request) {
        String uId = (String) request.getAttribute("uId");
        String appId = request.getParameter("appId");
        String appName = request.getParameter("appName");
        String serverType = request.getParameter("serverType");
        Gson gson = new Gson();
        if (ConfigConstants.DEF.equals(serverType)) {//自定义配置项查询
            String defAppRunEnv = (String) request.getParameter("defAppRunEnv");
            String defAppRunVersion = (String) request.getParameter("defAppRunVersion");
            return gson.toJson(configSetService.getListT(DefineConfigSet.class,
                    null, defAppRunEnv, appId, appName, uId, defAppRunVersion));
        }

        return gson.toJson(configSetService.getListT(ConfigSet.class, null
                , serverType, appId, appName, null, null));
    }
}
