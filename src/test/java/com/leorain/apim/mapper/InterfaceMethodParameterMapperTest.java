package com.leorain.apim.mapper;

import com.alibaba.fastjson.JSON;
import com.leorain.apim.entity.InterfaceMethodParameterEntity;
import com.leorain.apim.sevice.InterfaceMethodParameterService;
import com.leorain.apim.tools.JqPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterfaceMethodParameterMapperTest {

    @Autowired
    private InterfaceMethodParameterMapper interfaceMethodParameterMapper;

    @Autowired
    private InterfaceMethodParameterService interfaceMethodParameterService;

    @Test
    public void testInsert() throws Exception {
        interfaceMethodParameterMapper.insert(new InterfaceMethodParameterEntity(1L, 1L,
                1L, 1, "Integer",
                "java.lang.Integer", "userId", "用户ID",
                1, "dfasdf"));
        interfaceMethodParameterMapper.insert(new InterfaceMethodParameterEntity(2L, 1L,
                1L, 1, "Integer",
                "java.lang.Integer", "userId", "用户ID",
                1, "dfasdf"));
        interfaceMethodParameterMapper.insert(new InterfaceMethodParameterEntity(3L, 1L,
                1L, 1, "Integer",
                "java.lang.Integer", "userId", "用户ID",
                1, "dfasdf"));

        Assert.assertEquals(3, interfaceMethodParameterMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<InterfaceMethodParameterEntity> interfaceMethodParameterEntities = interfaceMethodParameterMapper.getAll();
        if (interfaceMethodParameterEntities == null || interfaceMethodParameterEntities.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(interfaceMethodParameterEntities.toString());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        InterfaceMethodParameterEntity interfaceMethodParameterEntity = interfaceMethodParameterMapper.getOne(1l);
        System.out.println(interfaceMethodParameterEntity.toString());
        interfaceMethodParameterEntity.setParameterName("userId");
        interfaceMethodParameterMapper.update(interfaceMethodParameterEntity);
        Assert.assertTrue(("userId".equals(interfaceMethodParameterMapper.getOne(1l).getParameterName())));
    }

    @Test
    public void testPage() {
        JqPage jqPage = new JqPage();
        jqPage.setPage(1);
        jqPage.setPageSize(10);
        jqPage = interfaceMethodParameterService.findInterfaceMethodParameterEntityPage(jqPage, null);
        System.out.println(JSON.toJSONString(jqPage));
    }

}