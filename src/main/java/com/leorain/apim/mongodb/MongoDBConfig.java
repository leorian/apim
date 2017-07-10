package com.leorain.apim.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoDBConfig {

    private static MongoClient mongoClient = null;
    private static MongoDatabase mDB = null;


    private String database;
    private String host;
    private int port;
    private String username;
    private String password;

    public void setDatabase(String database) {
        this.database = database;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @PostConstruct
    public void init() {
        System.out.println("mongodb客户端启动中.....");
        initMongoClient();
        initMongoDB();
        System.out.println("mongodb客户端启动完成");
    }

    private void initMongoDB() {
        if (mDB == null) {
            synchronized (this.getClass()) {
                if (mDB == null) {
                    mDB = mongoClient.getDatabase(database);
                }
            }
        }
    }

    private void initMongoClient() {
        if (mongoClient == null) {
            synchronized (this.getClass()) {
                if (mongoClient == null) {
                    MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
                    builder.connectionsPerHost(100);
                    builder.connectTimeout(1000 * 60 * 20);
                    builder.maxWaitTime(100 * 60 * 5);
                    builder.threadsAllowedToBlockForConnectionMultiplier(100);
                    builder.maxConnectionIdleTime(0);
                    builder.maxConnectionLifeTime(0);
                    builder.socketTimeout(0);
                    builder.socketKeepAlive(true);
                    MongoClientOptions mongoClientOptions = builder.build();
                    MongoCredential mongoCredential = MongoCredential.createCredential(username, database, password.toCharArray());
                    mongoClient = new MongoClient(new ServerAddress(host, port), Arrays.asList(mongoCredential), mongoClientOptions);
                }
            }
        }
    }

    public <T> MongoCollection<Document> getCollection(Class<T> tClass) {
        if (mDB == null) {
            init();
        }

        return mDB.getCollection(tClass.getSimpleName());
    }

}
