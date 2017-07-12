package com.leorain.apim.mapper;

import com.leorain.apim.entity.InterfaceResultEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterfaceResultMapperTest {

    @Autowired
    private InterfaceResultMapper interfaceResultMapper;

    @Test
    public void testInsert() throws Exception {
        interfaceResultMapper.insert(new InterfaceResultEntity(1l, 1l,
                "用户接口", "1", "com", "1"));
        interfaceResultMapper.insert(new InterfaceResultEntity(2l, 1l,
                "用户接口", "1", "com", "1"));
        interfaceResultMapper.insert(new InterfaceResultEntity(3l, 1l,
                "用户接口", "1", "com", "1"));

        Assert.assertEquals(3, interfaceResultMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<InterfaceResultEntity> interfaceResultEntities = interfaceResultMapper.getAll();
        if (interfaceResultEntities == null || interfaceResultEntities.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(interfaceResultEntities.toString());
        }
    }

    @Test
    public void testUpdate() throws Exception {
        InterfaceResultEntity interfaceResultEntity = interfaceResultMapper.getOne(1l);
        System.out.println(interfaceResultEntity.toString());
        interfaceResultEntity.setAttentionMatters("com.bozhong.hello.service.UserService");
        interfaceResultMapper.update(interfaceResultEntity);
        Assert.assertTrue(("com.bozhong.hello.service.UserService".equals(interfaceResultMapper.getOne(1l).getAttentionMatters())));
    }
}