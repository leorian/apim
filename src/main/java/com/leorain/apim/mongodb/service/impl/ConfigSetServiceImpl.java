package com.leorain.apim.mongodb.service.impl;

import com.leorain.apim.mongodb.dao.ConfigSetDao;
import com.leorain.apim.mongodb.domain.JqPage;
import com.leorain.apim.mongodb.service.ConfigSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by renyueliang on 16/12/29.
 */
@Service
public class ConfigSetServiceImpl implements ConfigSetService {

    @Autowired
    private ConfigSetDao configSetDao;

    @Override
    public <T> void insertOne(T t) {
        configSetDao.insertOne(t);
    }

    @Override
    public <T> void insertMany(List<T> list, Class<T> tClass) {
        configSetDao.insertMany(list, tClass);
    }

    @Override
    public <T> T findOneByKey(String key, Class<T> tClass) {
        return configSetDao.findOneByKey(key, tClass);
    }

    @Override
    public <T> T findOneByKey(String appId, String appName, String serverType, String key
            , String developerId, String version, Class<T> tClass) {
        return configSetDao.findOneByKey(appId, appName, serverType, key, developerId, version, tClass);
    }

    @Override
    public <T> void updateOneByKey(String key, T t) {
        configSetDao.updateOneByKey(key, t);
    }

    @Override
    public <T> void updateOneByKey(String appId, String appName, String serverType, String key
            , String developerId, String version, T t) {
        configSetDao.updateOneByKey(appId, appName, serverType, key, developerId, version, t);
    }

    @Override
    public <T> void deleteOneByKey(String key, Class<T> tClass) {
        configSetDao.deleteOneByKey(key, tClass);
    }

    @Override
    public <T> void deleteOneByKey(String appId, String appName, String serverType, String key, String developerId, String version, Class<T> tClass) {
        configSetDao.deleteOneByKey(appId, appName, serverType, key, developerId, version, tClass);
    }

    @Override
    public <T> JqPage<T> getJqPage(JqPage<T> configSetJqPage, Class<T> tClass) {
        return configSetDao.getJqPage(configSetJqPage, tClass);
    }

    @Override
    public <T> JqPage<T> getJqPage(JqPage<T> configSetJqPage, Class<T> tClass, String keyOrValue, String serverType) {
        return configSetDao.getJqPage(configSetJqPage, tClass, keyOrValue, serverType);
    }

    @Override
    public <T> JqPage<T> getJqPage(JqPage<T> configSetJqPage, Class<T> tClass, String keyOrValue, String serverType
            , String appId, String appName, String developerId, String version) {
        return configSetDao.getJqPage(configSetJqPage, tClass, keyOrValue, serverType, appId, appName, developerId, version);
    }

    @Override
    public <T> List<T> getListT(Class<T> tClass, String keyOrValue, String serverType, String appId, String appName, String developerId, String version) {
        return configSetDao.getListT(tClass, keyOrValue, serverType, appId, appName, developerId, version);
    }

    @Override
    public <T> List<T> findListByAppIdServerType(String appId, String appName, String serverType
            , String developerId, String version, Class<T> tClass) {
        return configSetDao.findListByAppIdServerType(appId, appName, serverType, developerId, version, tClass);
    }

}
