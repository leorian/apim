package com.leorain.apim.mapper;

import com.alibaba.fastjson.JSON;
import com.leorain.apim.entity.ApiUserEntity;
import com.leorain.apim.sevice.ApiUserService;
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
public class ApiUserMapperTest {

    @Autowired
    private ApiUserMapper apiUserMapper;

    @Autowired
    private ApiUserService apiUserService;

    @Test
    public void testInsert() throws Exception {
        apiUserMapper.insert(new ApiUserEntity(1l, "xiezg", "谢中贵", 1,
                "18605569807", "xiezg@317hu.com", "123456"));
        apiUserMapper.insert(new ApiUserEntity(2l, "zs", "张三", 1,
                "18605569807", "zs@317hu.com", "123456"));
        apiUserMapper.insert(new ApiUserEntity(3l, "ls", "李四", 1,
                "18605569807", "ls@317hu.com", "123456"));

        Assert.assertEquals(3, apiUserMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<ApiUserEntity> apiUserEntities = apiUserMapper.getAll();
        if (apiUserEntities == null || apiUserEntities.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(apiUserEntities.toString());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        ApiUserEntity apiUserEntity = apiUserMapper.getOne(1l);
        System.out.println(apiUserEntity.toString());
        apiUserEntity.setCellPhone("1860559808");
        apiUserMapper.update(apiUserEntity);
        Assert.assertTrue(("1860559808".equals(apiUserMapper.getOne(1l).getCellPhone())));
    }

    @Test
    public void testPage() {
        JqPage jqPage = new JqPage();
        jqPage.setPage(1);
        jqPage.setPageSize(10);
        jqPage = apiUserService.findApiUserEntityPage(jqPage, null);
        System.out.println(JSON.toJSONString(jqPage));
    }

}