package com.leorain.apim.mongodb.dao.impl;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.leorain.apim.mongodb.MongoDBConfig;
import com.leorain.apim.mongodb.dao.ConfigSetDao;
import com.leorain.apim.mongodb.domain.JqPage;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.descending;

/**
 * Created by renyueliang on 16/12/29.
 */
@Service
public class ConfigSetDaoImpl implements ConfigSetDao {
    @Autowired
    private MongoDBConfig mongoDBConfig;

    @Override
    public <T> void insertOne(T t) {
        Gson gson = new Gson();
        Document document = gson.fromJson(t.toString(), Document.class);
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(t.getClass());
        mongoCollection.insertOne(document);
    }

    @Override
    public <T> void insertMany(List<T> tlist, Class<T> tClass) {
        Gson gson = new Gson();
        List<Document> documentList = gson.fromJson(gson.toJson(tlist), new TypeToken<List<Document>>() {
        }.getType());
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        mongoCollection.insertMany(documentList);
    }

    @Override
    public <T> T findOneByKey(String key, Class<T> tClass) {
        Gson gson = new Gson();
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        Document document = mongoCollection.find(eq("key", key)).first();
        if (document != null) {
            return gson.fromJson(document.toJson(), tClass);
        }

        return null;
    }

    @Override
    public <T> T findOneByKey(String appId, String appName, String serverType, String key, String developerId
            , String version, Class<T> tClass) {
        Assert.notNull(appId, "appId can't be null!");
        //Assert.notNull(appName, "appName can't be null!");
        Assert.notNull(serverType, "serverType can't be null!");
        Assert.notNull(key, "key can't be null!");

        Gson gson = new Gson();
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        Bson filter = and(eq("appId", appId)
                //,eq("appName", appName)
                , eq("serverType", serverType), eq("key", key));
        //开发者编号
        if (!StringUtils.isEmpty(developerId)) {
            filter = and(filter, eq("developerId", developerId));
        }
        //开发者版本编号
        if (!StringUtils.isEmpty(version)) {
            filter = and(filter, eq("version", version));
        }

        Document document = mongoCollection.find(filter).first();
        if (document != null) {
            return gson.fromJson(document.toJson(), tClass);
        }

        return null;
    }

    @Override
    public <T> void updateOneByKey(String key, T t) {
        Gson gson = new Gson();
        Document document = gson.fromJson(t.toString(), Document.class);
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(t.getClass());
        mongoCollection.updateOne(eq("key", key), new Document("$set", document));
    }

    @Override
    public <T> void updateOneByKey(String appId, String appName, String serverType, String key
            , String developerId, String version, T t) {
        Assert.notNull(appId, "appId can't be null!");
        //Assert.notNull(appName, "appName can't be null!");
        Assert.notNull(serverType, "serverType can't be null!");
        Assert.notNull(key, "key can't be null!");
        Gson gson = new Gson();
        Document document = gson.fromJson(t.toString(), Document.class);
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(t.getClass());
        Bson filter = and(eq("appId", appId)
                //, eq("appName", appName)
                , eq("serverType", serverType), eq("key", key));
        if (!StringUtils.isEmpty(developerId)) {
            filter = and(filter, eq("developerId", developerId));
        }

        if (!StringUtils.isEmpty(version)) {
            filter = and(filter, eq("version", version));
        }

        mongoCollection.updateOne(filter, new Document("$set", document));
    }

    @Override
    public <T> void deleteOneByKey(String key, Class<T> tClass) {
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        mongoCollection.deleteOne(eq("key", key));
    }

    @Override
    public <T> void deleteOneByKey(String appId, String appName, String serverType, String key, String developerId
            , String version, Class<T> tClass) {
        Assert.notNull(appId, "appId can't be null!");
        //Assert.notNull(appName, "appName can't be null!");
        Assert.notNull(serverType, "serverType can't be null!");
        Assert.notNull(key, "key can't be null!");
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        Bson bson = and(eq("appId", appId),
                //eq("appName", appName),
                eq("serverType", serverType), eq("key", key));
        if (!StringUtils.isEmpty(developerId)) {
            bson = and(bson, eq("developerId", developerId));
        }

        if (!StringUtils.isEmpty(version)) {
            bson = and(bson, eq("version", version));
        }

        mongoCollection.deleteOne(bson);
    }


    @Override
    public <T> JqPage<T> getJqPage(JqPage<T> configSetJqPage, Class<T> tClass) {
        return getJqPage(configSetJqPage, tClass, null, null);
    }

    @Override
    public <T> JqPage<T> getJqPage(JqPage<T> configSetJqPage, Class<T> tClass, String keyOrValue, String serverType) {
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        Bson filter = null;
        if (serverType != null && !StringUtils.isEmpty(keyOrValue)) {
            filter = and(eq("serverType", serverType), or(regex("key", "^.*" + keyOrValue + ".*$"), regex("value", "^.*" + keyOrValue + ".*$")));
        } else if (serverType != null) {
            filter = eq("serverType", serverType);
        } else if (!StringUtils.isEmpty(keyOrValue)) {
            filter = or(regex("key", "^.*" + keyOrValue + ".*$"), regex("value", "^.*" + keyOrValue + ".*$"));
        }

        FindIterable<Document> findIterable = null;
        if (filter != null) {
            findIterable = mongoCollection.find(filter).sort(descending("createTime")).skip(configSetJqPage.getFromIndex()).limit(configSetJqPage.getPageSize());
        } else {
            findIterable = mongoCollection.find().sort(descending("createTime")).skip(configSetJqPage.getFromIndex()).limit(configSetJqPage.getPageSize());
        }

        Iterator<Document> iterator = findIterable.iterator();
        List<T> rows = new ArrayList<T>(configSetJqPage.getPageSize());
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        while (iterator.hasNext()) {
            Document document = iterator.next();
            rows.add(gson.fromJson(document.toJson(), tClass));
        }
        if (filter != null) {
            configSetJqPage.setRecords((int) mongoCollection.count(filter));
        } else {
            configSetJqPage.setRecords((int) mongoCollection.count());
        }
        configSetJqPage.setRows(rows);
        return configSetJqPage;
    }

    @Override
    public <T> JqPage<T> getJqPage(JqPage<T> configSetJqPage, Class<T> tClass, String keyOrValue, String serverType
            , String appId, String appName, String developerId, String version) {
        Assert.notNull(appId, "appId can't be null!");
        //Assert.notNull(appName, "appName can't be null!");
        //Assert.notNull(serverType, "serverType can't be null!");
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        Bson filter = null;
        if (serverType != null && !StringUtils.isEmpty(keyOrValue)) {
            filter = and(eq("serverType", serverType), or(regex("key", "^.*" + keyOrValue + ".*$"), regex("value", "^.*" + keyOrValue + ".*$")));
        } else if (serverType != null) {
            filter = eq("serverType", serverType);
        } else if (!StringUtils.isEmpty(keyOrValue)) {
            filter = or(regex("key", "^.*" + keyOrValue + ".*$"), regex("value", "^.*" + keyOrValue + ".*$"));
        }

        if (filter == null) {
            filter = and(eq("appId", appId)
                    //        , eq("appName", appName)
            );
        } else {
            filter = and(eq("appId", appId)
                    //, eq("appName", appName)
                    , filter);
        }

        if (!StringUtils.isEmpty(developerId)) {
            filter = and(filter, eq("developerId", developerId));
        }

        if (!StringUtils.isEmpty(version)) {
            filter = and(filter, eq("version", version));
        }

        FindIterable<Document> findIterable = null;
        if (filter != null) {
            findIterable = mongoCollection.find(filter).sort(descending("createTime")).skip(configSetJqPage.getFromIndex()).limit(configSetJqPage.getPageSize());
        } else {
            findIterable = mongoCollection.find().sort(descending("createTime")).skip(configSetJqPage.getFromIndex()).limit(configSetJqPage.getPageSize());
        }

        Iterator<Document> iterator = findIterable.iterator();
        List<T> rows = new ArrayList<T>(configSetJqPage.getPageSize());
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        while (iterator.hasNext()) {
            Document document = iterator.next();
            rows.add(gson.fromJson(document.toJson(), tClass));
        }

        if (filter != null) {
            configSetJqPage.setRecords((int) mongoCollection.count(filter));
        } else {
            configSetJqPage.setRecords((int) mongoCollection.count());
        }
        configSetJqPage.setRows(rows);
        return configSetJqPage;
    }

    @Override
    public <T> List<T> getListT(Class<T> tClass, String keyOrValue, String serverType, String appId, String appName, String developerId, String version) {
        Assert.notNull(appId, "appId can't be null!");
        //Assert.notNull(appName, "appName can't be null!");
        //Assert.notNull(serverType, "serverType can't be null!");
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        Bson filter = null;
        if (serverType != null && !StringUtils.isEmpty(keyOrValue)) {
            filter = and(eq("serverType", serverType), or(regex("key", "^.*" + keyOrValue + ".*$"), regex("value", "^.*" + keyOrValue + ".*$")));
        } else if (serverType != null) {
            filter = eq("serverType", serverType);
        } else if (!StringUtils.isEmpty(keyOrValue)) {
            filter = or(regex("key", "^.*" + keyOrValue + ".*$"), regex("value", "^.*" + keyOrValue + ".*$"));
        }

        if (filter == null) {
            filter = and(eq("appId", appId)
                    //        , eq("appName", appName)
            );
        } else {
            filter = and(eq("appId", appId)
                    //, eq("appName", appName)
                    , filter);
        }

        if (!StringUtils.isEmpty(developerId)) {
            filter = and(filter, eq("developerId", developerId));
        }

        if (!StringUtils.isEmpty(version)) {
            filter = and(filter, eq("version", version));
        }

        FindIterable<Document> findIterable = null;
        if (filter != null) {
            findIterable = mongoCollection.find(filter).sort(descending("createTime"));
        } else {
            findIterable = mongoCollection.find().sort(descending("createTime"));
        }

        Iterator<Document> iterator = findIterable.iterator();
        List<T> rows = new ArrayList<T>();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        while (iterator.hasNext()) {
            Document document = iterator.next();
            rows.add(gson.fromJson(document.toJson(), tClass));
        }

        return rows;
    }

    @Override
    public <T> List<T> findListByAppIdServerType(String appId, String appName, String serverType,
                                                 String developerId, String version, Class<T> tClass) {
        Assert.notNull(appId, "appId can't be null!");
        //Assert.notNull(appName, "appName can't be null!");
        Assert.notNull(serverType, "serverType can't be null!");
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        Bson filter = and(eq("appId", appId)
                //, eq("appName", appName)
                , eq("serverType", serverType));
        if (!StringUtils.isEmpty(developerId)) {
            filter = and(filter, eq("developerId", developerId));
        }

        if (!StringUtils.isEmpty(version)) {
            filter = and(filter, eq("version", version));
        }

        FindIterable<Document> findIterable = mongoCollection.find(filter);
        Iterator<Document> iterator = findIterable.iterator();
        List<T> tList = new ArrayList<T>();
        Gson gson = new Gson();
        while (iterator.hasNext()) {
            Document document = iterator.next();
            tList.add(gson.fromJson(document.toJson(), tClass));
        }
        return tList;
    }
}
