package com.leorain.apim.mapper;

import com.leorain.apim.entity.InterfaceRpcEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterfaceRpcMapperTest {

    @Autowired
    private InterfaceRpcMapper interfaceRpcMapper;

    @Test
    public void testInsert() throws Exception {
        interfaceRpcMapper.insert(new InterfaceRpcEntity(1l, 1l, "用户接口",
                "1", "com.bozhong.test.service.UserService", "1","",""));
        interfaceRpcMapper.insert(new InterfaceRpcEntity(2l, 1l, "用户接口",
                "1", "com.bozhong.test.service.UserService", "1","",""));
        interfaceRpcMapper.insert(new InterfaceRpcEntity(3l, 1l, "用户接口",
                "1", "com.bozhong.test.service.UserService", "1","",""));

        Assert.assertEquals(3, interfaceRpcMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<InterfaceRpcEntity> interfaceRpcEntities = interfaceRpcMapper.getAll();
        if (interfaceRpcEntities == null || interfaceRpcEntities.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(interfaceRpcEntities.toString());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        InterfaceRpcEntity interfaceRpcEntity = interfaceRpcMapper.getOne(1l);
        System.out.println(interfaceRpcEntity.toString());
        interfaceRpcEntity.setName("com.bozhong.hello.service.UserService");
        interfaceRpcMapper.update(interfaceRpcEntity);
        Assert.assertTrue(("com.bozhong.hello.service.UserService".equals(interfaceRpcMapper.getOne(1l).getName())));
    }

}