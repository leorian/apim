package com.leorain.apim.mapper;

import com.leorain.apim.entity.InterfaceHttpEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterfaceHttpMapperTest {

    @Autowired
    private InterfaceHttpMapper interfaceHttpMapper;

    @Test
    public void testInsert() throws Exception {
        interfaceHttpMapper.insert(new InterfaceHttpEntity(1l, 1l, "用户接口",
                "1", "com", "1", "5", "dd"));
        interfaceHttpMapper.insert(new InterfaceHttpEntity(2l, 1l, "用户接口",
                "1", "com", "1", "5", "dd"));
        interfaceHttpMapper.insert(new InterfaceHttpEntity(3l, 1l, "用户接口",
                "1", "com", "1", "5", "dd"));

        Assert.assertEquals(3, interfaceHttpMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<InterfaceHttpEntity> interfaceHttpEntities = interfaceHttpMapper.getAll();
        if (interfaceHttpEntities == null || interfaceHttpEntities.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(interfaceHttpEntities.toString());
        }
    }

    @Test
    public void testUpdate() throws Exception {
        InterfaceHttpEntity interfaceHttpEntity = interfaceHttpMapper.getOne(1l);
        System.out.println(interfaceHttpEntity.toString());
        interfaceHttpEntity.setDescription("com.bozhong.hello.service.UserService");
        interfaceHttpMapper.update(interfaceHttpEntity);
        Assert.assertTrue(("com.bozhong.hello.service.UserService".equals(interfaceHttpMapper.getOne(1l).getDescription())));
    }
}