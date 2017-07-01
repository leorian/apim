package com.leorain.apim.mapper;

import com.alibaba.fastjson.JSON;
import com.leorain.apim.entity.InterfaceMethodEntity;
import com.leorain.apim.sevice.InterfaceMethodService;
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
public class InterfaceMethodMapperTest {

    @Autowired
    private InterfaceMethodMapper interfaceMethodMapper;

    @Autowired
    private InterfaceMethodService interfaceMethodService;

    @Test
    public void testInsert() throws Exception {
        interfaceMethodMapper.insert(new InterfaceMethodEntity(1l, 1l,
                "findUser", "查找用户",
                "String userId", "void"));
        interfaceMethodMapper.insert(new InterfaceMethodEntity(2l, 1l,
                "findUser", "查找用户",
                "String userId", "void"));
        interfaceMethodMapper.insert(new InterfaceMethodEntity(3l, 1l,
                "findUser", "查找用户",
                "String userId", "void"));

        Assert.assertEquals(3, interfaceMethodMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<InterfaceMethodEntity> interfaceMethodEntities = interfaceMethodMapper.getAll();
        if (interfaceMethodEntities == null || interfaceMethodEntities.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(interfaceMethodEntities.toString());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        InterfaceMethodEntity interfaceMethodEntity = interfaceMethodMapper.getOne(1l);
        System.out.println(interfaceMethodEntity.toString());
        interfaceMethodEntity.setInterfaceMethodName("updateUser");
        interfaceMethodMapper.update(interfaceMethodEntity);
        Assert.assertTrue(("updateUser".equals(interfaceMethodMapper.getOne(1l).getInterfaceMethodName())));
    }

    @Test
    public void testPage() {
        JqPage jqPage = new JqPage();
        jqPage.setPage(1);
        jqPage.setPageSize(10);
        jqPage = interfaceMethodService.findInterfaceMethodEntityPage(jqPage, null);
        System.out.println(JSON.toJSONString(jqPage));
    }

}