package com.leorain.apim.mapper;

import com.leorain.apim.entity.InterfaceEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterfaceMapperTest {

    @Autowired
    private InterfaceMapper interfaceMapper;

    @Test
    public void testInsert() throws Exception {
        interfaceMapper.insert(new InterfaceEntity(1l, 1l, "用户接口",
                1, "com.bozhong.test.service.UserService", 1));
        interfaceMapper.insert(new InterfaceEntity(2l, 1l, "用户接口",
                1, "com.bozhong.test.service.UserService", 1));
        interfaceMapper.insert(new InterfaceEntity(2l, 1l, "用户接口",
                1, "com.bozhong.test.service.UserService", 1));

        Assert.assertEquals(3, interfaceMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<InterfaceEntity> interfaceEntities = interfaceMapper.getAll();
        if (interfaceEntities == null || interfaceEntities.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(interfaceEntities.toString());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        InterfaceEntity interfaceEntity = interfaceMapper.getOne(1l);
        System.out.println(interfaceEntity.toString());
        interfaceEntity.setInterfaceAddress("com.bozhong.hello.service.UserService");
        interfaceMapper.update(interfaceEntity);
        Assert.assertTrue(("com.bozhong.hello.service.UserService".equals(interfaceMapper.getOne(1l).getInterfaceAddress())));
    }

}