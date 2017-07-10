package com.leorain.apim.mongodb.service;


import com.leorain.apim.mongodb.domain.JqPage;

import java.util.List;

/**
 * Created by renyueliang on 16/12/29.
 */
public interface ConfigSetService {

    /**
     * @param t
     * @param <T>
     */
    <T> void insertOne(T t);

    /**
     * @param tList
     * @param tClass
     * @param <T>
     */
    <T> void insertMany(List<T> tList, Class<T> tClass);

    /**
     * @param key
     * @param tClass
     * @param <T>
     * @return
     */
    <T> T findOneByKey(String key, Class<T> tClass);

    /**
     * @param appId
     * @param appName
     * @param serverType
     * @param key
     * @param developerId
     * @param version
     * @param tClass
     * @param <T>
     * @return
     */
    <T> T findOneByKey(String appId, String appName, String serverType, String key
            , String developerId, String version, Class<T> tClass);

    /**
     * @param key
     * @param t
     * @param <T>
     */
    <T> void updateOneByKey(String key, T t);

    /**
     * @param appId
     * @param appName
     * @param serverType
     * @param key
     * @param developerId
     * @param version
     * @param t
     * @param <T>
     */
    <T> void updateOneByKey(String appId, String appName, String serverType, String key
            , String developerId, String version, T t);

    /**
     * @param key
     * @param tClass
     * @param <T>
     */
    <T> void deleteOneByKey(String key, Class<T> tClass);

    /**
     * @param appId
     * @param appName
     * @param serverType
     * @param key
     * @param developerId
     * @param version
     * @param tClass
     * @param <T>
     */
    <T> void deleteOneByKey(String appId, String appName, String serverType, String key, String developerId
            , String version, Class<T> tClass);

    /**
     * @param configSetJqPage
     * @param tClass
     * @param <T>
     * @return
     */
    <T> JqPage<T> getJqPage(JqPage<T> configSetJqPage, Class<T> tClass);

    /**
     * @param configSetJqPage
     * @param tClass
     * @param keyOrValue
     * @param serverType
     * @param <T>
     * @return
     */
    <T> JqPage<T> getJqPage(JqPage<T> configSetJqPage, Class<T> tClass, String keyOrValue, String serverType);

    /**
     * @param configSetJqPage
     * @param tClass
     * @param keyOrValue
     * @param serverType
     * @param appId
     * @param appName
     * @param developerId
     * @param version
     * @param <T>
     * @return
     */
    <T> JqPage<T> getJqPage(JqPage<T> configSetJqPage, Class<T> tClass, String keyOrValue, String serverType
            , String appId, String appName, String developerId, String version);

    /**
     * @param tClass
     * @param keyOrValue
     * @param serverType
     * @param appId
     * @param appName
     * @param developerId
     * @param version
     * @param <T>
     * @return
     */
    <T> List<T> getListT(Class<T> tClass, String keyOrValue, String serverType, String appId, String appName,
                         String developerId, String version);

    /**
     * @param appId
     * @param appName
     * @param serverType
     * @param developerId
     * @param version
     * @param tClass
     * @param <T>
     * @return
     */
    <T> List<T> findListByAppIdServerType(String appId, String appName, String serverType
            , String developerId, String version, Class<T> tClass);
}
