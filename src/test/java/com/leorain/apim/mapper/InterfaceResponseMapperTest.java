package com.leorain.apim.mapper;

import com.alibaba.fastjson.JSON;
import com.leorain.apim.entity.InterfaceResponseEntity;
import com.leorain.apim.sevice.InterfaceResponseService;
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
public class InterfaceResponseMapperTest {

    @Autowired
    private InterfaceResponseMapper interfaceResponseMapper;

    @Autowired
    private InterfaceResponseService interfaceResponseService;

    @Test
    public void testInsert() throws Exception {
        interfaceResponseMapper.insert(new InterfaceResponseEntity(1L, 1L,
                1, 1,
                "java.lang.Integer", "userId"));
        interfaceResponseMapper.insert(new InterfaceResponseEntity(2L, 1L,
                1, 1,
                "java.lang.Integer", "userId"));
        interfaceResponseMapper.insert(new InterfaceResponseEntity(3L, 1L,
                1, 1,
                "java.lang.Integer", "userId"));

        Assert.assertEquals(3, interfaceResponseMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<InterfaceResponseEntity> interfaceResponseEntities = interfaceResponseMapper.getAll();
        if (interfaceResponseEntities == null || interfaceResponseEntities.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(interfaceResponseEntities.toString());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        InterfaceResponseEntity interfaceResponseEntity = interfaceResponseMapper.getOne(1l);
        System.out.println(interfaceResponseEntity.toString());
        interfaceResponseEntity.setResponseExample("Hello");
        interfaceResponseMapper.update(interfaceResponseEntity);
        Assert.assertTrue(("Hello".equals(interfaceResponseMapper.getOne(1l).getResponseExample())));
    }

    @Test
    public void testPage() {
        JqPage jqPage = new JqPage();
        jqPage.setPage(1);
        jqPage.setPageSize(10);
        jqPage = interfaceResponseService.findInterfaceResponseEntityPage(jqPage, null);
        System.out.println(JSON.toJSONString(jqPage));
    }

}