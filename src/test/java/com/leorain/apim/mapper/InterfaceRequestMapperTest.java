package com.leorain.apim.mapper;

import com.leorain.apim.entity.InterfaceRequestEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterfaceRequestMapperTest {

    @Autowired
    private InterfaceRequestMapper interfaceRequestMapper;

    @Test
    public void testInsert() throws Exception {
        interfaceRequestMapper.insert(new InterfaceRequestEntity(1L, 1L,
                1, "Integer",
                "java.lang.Integer",1 ,"userId"));
        interfaceRequestMapper.insert(new InterfaceRequestEntity(2L, 1L,
                1, "Integer",
                "java.lang.Integer",1 ,"userId"));
        interfaceRequestMapper.insert(new InterfaceRequestEntity(3L, 1L,
                1, "Integer",
                "java.lang.Integer",1 ,"userId"));

        Assert.assertEquals(3, interfaceRequestMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<InterfaceRequestEntity> interfaceRequestEntities = interfaceRequestMapper.getAll();
        if (interfaceRequestEntities == null || interfaceRequestEntities.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(interfaceRequestEntities.toString());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        InterfaceRequestEntity interfaceRequestEntity = interfaceRequestMapper.getOne(1l);
        System.out.println(interfaceRequestEntity.toString());
        interfaceRequestEntity.setRequestParameterName("userId");
        interfaceRequestMapper.update(interfaceRequestEntity);
        Assert.assertTrue(("userId".equals(interfaceRequestMapper.getOne(1l).getRequestParameterName())));
    }

}