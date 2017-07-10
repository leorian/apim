package com.leorain.apim.web;

import com.google.gson.Gson;
import com.leorain.apim.mongodb.consts.ConfigConstants;
import com.leorain.apim.mongodb.domain.ConfigSet;
import com.leorain.apim.mongodb.domain.DefineConfigSet;
import com.leorain.apim.mongodb.domain.RecordConfig;
import com.leorain.apim.mongodb.enums.OperationType;
import com.leorain.apim.mongodb.exception.ConfigCenterCodeEnum;
import com.leorain.apim.mongodb.service.ConfigSetService;
import com.leorain.apim.mongodb.util.LDAPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/7/10 0010.
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    private ConfigSetService configSetService;

    /**
     * 应用、环境配置项列表查询
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getAllConfigSetList", method = RequestMethod.POST)
    public String getAllConfigSetList(HttpServletRequest request) {
        String uId = (String) request.getAttribute("uId");
        String appId = request.getParameter("appId");
        String appName = request.getParameter("appName");
        String serverType = request.getParameter("serverType");
        Gson gson = new Gson();
        if (ConfigConstants.DEF.equals(serverType)) {//自定义配置项查询
            String defAppRunEnv = request.getParameter("defAppRunEnv");
            String defAppRunVersion = request.getParameter("defAppRunVersion");
            return gson.toJson(configSetService.getListT(DefineConfigSet.class,
                    null, defAppRunEnv, appId, appName, uId, defAppRunVersion));
        }

        return gson.toJson(configSetService.getListT(ConfigSet.class, null
                , serverType, appId, appName, null, null));
    }

    /**
     * 配置项提交前验证
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/beforeSaveConfigCheck", method = RequestMethod.POST)
    public String beforeSaveConfigCheck(HttpServletRequest request) {
        Gson gson = new Gson();
        Map<String, String> resultMap = new HashMap<String, String>();
        String uId = (String) request.getAttribute("uId");
        String appId = request.getParameter("appId");
        if (StringUtils.isEmpty(appId)) {
            return ConfigCenterCodeEnum.T1001.toString();
        }

        String appName = request.getParameter("appName");
        String serverType = request.getParameter("serverType");
        if (StringUtils.isEmpty(serverType)) {
            return ConfigCenterCodeEnum.T1002.toString();
        }

        String appProperties = request.getParameter("appProperties");
        if (ConfigConstants.DEF.equals(serverType)) {//自定义配置选项
            String defAppRunEnv = request.getParameter("defAppRunEnv");
            String defAppRunVersion = request.getParameter("defAppRunVersion");
            List<DefineConfigSet> defineConfigSetList = LDAPUtil.translateDefineConfigSetFromAppProperties(appProperties);
            if (!CollectionUtils.isEmpty(defineConfigSetList)) {
                //新增提示信息
                StringBuffer addSB = new StringBuffer();
                addSB.append("新增\r\n");
                //修改提示信息
                StringBuffer updateSB = new StringBuffer();
                updateSB.append("本次提交：\r\n");
                for (DefineConfigSet defineConfigSet : defineConfigSetList) {
                    DefineConfigSet oldDefineConfigSet = configSetService.findOneByKey(appId, appName, defAppRunEnv, defineConfigSet.getKey(), uId, defAppRunVersion, DefineConfigSet.class);
                    if (oldDefineConfigSet == null) {
                        addSB.append(defineConfigSet.getKey()).append(" 值 ").append(defineConfigSet.getValue()).append("\r\n");
                    } else {
                        updateSB.append(defineConfigSet.getKey()).append("值被修改 修改前").append(oldDefineConfigSet.getValue()).append("\r\n");
                    }
                }
                resultMap.put("code", "SUCCESS");
                resultMap.put("msg", updateSB.append(addSB).toString().replaceAll("\r\n", "<br/>"));
                return gson.toJson(resultMap);
            }

            return ConfigCenterCodeEnum.T1003.toString();
        }

        List<ConfigSet> configSetList = LDAPUtil.translateConfigSetFromAppProperties(appProperties);
        if (!CollectionUtils.isEmpty(configSetList)) {
            //新增提示信息
            StringBuffer addSB = new StringBuffer();
            addSB.append("新增\r\n");
            //修改提示信息
            StringBuffer updateSB = new StringBuffer();
            updateSB.append("本次提交：\r\n");
            for (ConfigSet configSet : configSetList) {
                ConfigSet oldConfigSet = configSetService.findOneByKey(appId, appName, serverType, configSet.getKey(), null, null, ConfigSet.class);
                if (oldConfigSet == null) {
                    addSB.append(configSet.getKey()).append(" 值 ").append(configSet.getValue()).append("\r\n");
                } else {
                    updateSB.append(configSet.getKey()).append("值被修改 修改前").append(oldConfigSet.getValue()).append("\r\n");
                }
            }
            resultMap.put("code", "SUCCESS");
            resultMap.put("msg", updateSB.append(addSB).toString().replaceAll("\r\n", "<br/>"));
            return gson.toJson(resultMap);
        }

        return ConfigCenterCodeEnum.T1003.toString();
    }

    /**
     * 配置项提交
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/saveConfig", method = RequestMethod.POST)
    public String saveConfig(HttpServletRequest request) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String uId = (String) request.getAttribute("uId");
        String appId = request.getParameter("appId");
        if (StringUtils.isEmpty(appId)) {
            return ConfigCenterCodeEnum.T1001.toString();
        }

        String appName = request.getParameter("appName");
        String serverType = request.getParameter("serverType");
        if (StringUtils.isEmpty(serverType)) {
            return ConfigCenterCodeEnum.T1002.toString();
        }

        String appProperties = request.getParameter("appProperties");
        if (ConfigConstants.DEF.equals(serverType)) {//自定义配置项提交
            String defAppRunEnv = request.getParameter("defAppRunEnv");
            String defAppRunVersion = request.getParameter("defAppRunVersion");
            List<DefineConfigSet> defineConfigSetList = LDAPUtil.translateDefineConfigSetFromAppProperties(appProperties);
            if (CollectionUtils.isEmpty(defineConfigSetList)) {
                return ConfigCenterCodeEnum.T1003.toString();
            }
            for (DefineConfigSet defineConfigSet : defineConfigSetList) {
                DefineConfigSet oldDefineConfigSet = configSetService.findOneByKey(appId, appName, defAppRunEnv
                        , defineConfigSet.getKey(), uId, defAppRunVersion, DefineConfigSet.class);
                if (oldDefineConfigSet == null) {
                    defineConfigSet.setCreateId(uId);
                    defineConfigSet.setCreateTime(simpleDateFormat.format(new Date()));
                    defineConfigSet.setUpdateId(uId);
                    defineConfigSet.setUpdateTime(simpleDateFormat.format(new Date()));
                    defineConfigSet.setAppId(appId);
                    defineConfigSet.setAppName(appName);
                    defineConfigSet.setDeveloperId(uId);
                    defineConfigSet.setServerType(defAppRunEnv);
                    defineConfigSet.setVersion(defAppRunVersion);
                    configSetService.insertOne(defineConfigSet);
                } else {
                    oldDefineConfigSet.setValue(defineConfigSet.getValue());
                    oldDefineConfigSet.setUpdateId(uId);
                    oldDefineConfigSet.setUpdateTime(simpleDateFormat.format(new Date()));
                    configSetService.updateOneByKey(appId, appName, defAppRunEnv, oldDefineConfigSet.getKey()
                            , uId, defAppRunVersion, oldDefineConfigSet);
                }
            }
            return ConfigCenterCodeEnum.T1004.toString();
        }

        List<ConfigSet> configSetList = LDAPUtil.translateConfigSetFromAppProperties(appProperties);
        if (CollectionUtils.isEmpty(configSetList)) {
            return ConfigCenterCodeEnum.T1003.toString();
        }

        for (ConfigSet configSet : configSetList) {
            ConfigSet oldConfigSet = configSetService.findOneByKey(appId, appName, serverType, configSet.getKey()
                    , null, null, ConfigSet.class);
            if (oldConfigSet == null) {

                //新增
                configSet.setAppId(appId);
                configSet.setAppName(appName);
                configSet.setServerType(serverType);
                configSet.setCreateId(uId);
                configSet.setCreateTime(simpleDateFormat.format(new Date()));
                configSet.setUpdateId(uId);
                configSet.setUpdateTime(simpleDateFormat.format(new Date()));
                configSetService.insertOne(configSet);

                //操作记录
                RecordConfig recordConfig = new RecordConfig();
                recordConfig.setAppId(appId);
                recordConfig.setAppName(appName);
                recordConfig.setServerType(serverType);
                recordConfig.setOperationType(OperationType.ADD.name());
                recordConfig.setCreateId(uId);
                recordConfig.setCreateTime(simpleDateFormat.format(new Date()));
                recordConfig.setKey(configSet.getKey());
                recordConfig.setPreValue("");
                recordConfig.setValue(configSet.getValue());
                System.out.println(recordConfig.toString());
                configSetService.insertOne(recordConfig);

            } else {
                String oldValue = oldConfigSet.getValue();
                //更新
                oldConfigSet.setValue(configSet.getValue());
                oldConfigSet.setUpdateId(uId);
                oldConfigSet.setUpdateTime(simpleDateFormat.format(new Date()));
                configSetService.updateOneByKey(appId, appName, serverType, oldConfigSet.getKey()
                        , null, null, oldConfigSet);

                //操作记录
                RecordConfig recordConfig = new RecordConfig();
                recordConfig.setAppId(appId);
                recordConfig.setAppName(appName);
                recordConfig.setServerType(serverType);
                recordConfig.setOperationType(OperationType.UPDATE.name());
                recordConfig.setCreateId(uId);
                recordConfig.setCreateTime(simpleDateFormat.format(new Date()));
                recordConfig.setKey(configSet.getKey());
                recordConfig.setPreValue(oldValue);
                recordConfig.setValue(configSet.getValue());
                System.out.println(recordConfig.toString());
                configSetService.insertOne(recordConfig);
            }
        }

        return ConfigCenterCodeEnum.T1004.toString();
    }
}
