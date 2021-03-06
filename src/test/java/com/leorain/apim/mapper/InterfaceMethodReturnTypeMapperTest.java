package com.leorain.apim.mapper;

import com.alibaba.fastjson.JSON;
import com.leorain.apim.entity.InterfaceMethodReturnTypeEntity;
import com.leorain.apim.sevice.InterfaceMethodReturnTypeService;
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
public class InterfaceMethodReturnTypeMapperTest {

    @Autowired
    private InterfaceMethodReturnTypeMapper interfaceMethodReturnTypeMapper;

    @Autowired
    private InterfaceMethodReturnTypeService interfaceMethodReturnTypeService;

    @Test
    public void testInsert() throws Exception {
        interfaceMethodReturnTypeMapper.insert(new InterfaceMethodReturnTypeEntity(1L, 1L,
                1L, "Integer",
                "java.lang.Integer", "userId"));
        interfaceMethodReturnTypeMapper.insert(new InterfaceMethodReturnTypeEntity(2L, 1L,
                1L, "Integer",
                "java.lang.Integer", "userId"));
        interfaceMethodReturnTypeMapper.insert(new InterfaceMethodReturnTypeEntity(3L, 1L,
                1L, "Integer",
                "java.lang.Integer", "userId"));

        Assert.assertEquals(3, interfaceMethodReturnTypeMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<InterfaceMethodReturnTypeEntity> interfaceMethodReturnTypeEntities = interfaceMethodReturnTypeMapper.getAll();
        if (interfaceMethodReturnTypeEntities == null || interfaceMethodReturnTypeEntities.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(interfaceMethodReturnTypeEntities.toString());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        InterfaceMethodReturnTypeEntity interfaceMethodReturnTypeEntity = interfaceMethodReturnTypeMapper.getOne(1l);
        System.out.println(interfaceMethodReturnTypeEntity.toString());
        interfaceMethodReturnTypeEntity.setReturnTypeShortName("String");
        interfaceMethodReturnTypeMapper.update(interfaceMethodReturnTypeEntity);
        Assert.assertTrue(("String".equals(interfaceMethodReturnTypeMapper.getOne(1l).getReturnTypeShortName())));
    }


    @Test
    public void testPage() {
        JqPage jqPage = new JqPage();
        jqPage.setPage(1);
        jqPage.setPageSize(10);
        jqPage = interfaceMethodReturnTypeService.findInterfaceMethodReturnTypeEntityPage(jqPage, null);
        System.out.println(JSON.toJSONString(jqPage));
    }
}