package com.leorain.apim.mapper;

import com.leorain.apim.entity.InterfaceHttpEntity;
import com.leorain.apim.entity.InterfaceParamEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterfaceParamMapperTest {

    @Autowired
    private InterfaceParamMapper interfaceParamMapper;

    @Test
    public void testInsert() throws Exception {
        interfaceParamMapper.insert(new InterfaceParamEntity(1l, 1l,
                "用户接口", "1", "com", "1",
                true, false, "dd","dd"));
        interfaceParamMapper.insert(new InterfaceParamEntity(2l, 1l,
                "用户接口", "1", "com", "1",
                true, false, "dd","dd"));
        interfaceParamMapper.insert(new InterfaceParamEntity(3l, 1l,
                "用户接口", "1", "com", "1",
                true, false, "dd","dd"));

        Assert.assertEquals(3, interfaceParamMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<InterfaceParamEntity> interfaceParamEntities = interfaceParamMapper.getAll();
        if (interfaceParamEntities == null || interfaceParamEntities.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(interfaceParamEntities.toString());
        }
    }

    @Test
    public void testUpdate() throws Exception {
        InterfaceParamEntity interfaceParamEntity = interfaceParamMapper.getOne(1l);
        System.out.println(interfaceParamEntity.toString());
        interfaceParamEntity.setDefaultValue("com.bozhong.hello.service.UserService");
        interfaceParamMapper.update(interfaceParamEntity);
        Assert.assertTrue(("com.bozhong.hello.service.UserService".equals(interfaceParamMapper.getOne(1l).getDefaultValue())));
    }
}