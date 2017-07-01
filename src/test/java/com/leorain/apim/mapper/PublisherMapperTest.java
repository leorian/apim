package com.leorain.apim.mapper;

import com.alibaba.fastjson.JSON;
import com.leorain.apim.entity.PublisherEntity;
import com.leorain.apim.sevice.PublisherService;
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
public class PublisherMapperTest {

    @Autowired
    private PublisherMapper publisherMapper;

    @Autowired
    private PublisherService publisherService;

    @Test
    public void testInsert() throws Exception {
        publisherMapper.insert(new PublisherEntity(1L,
                1l, 1, "afdafdasf", "fda", "fdafd"));
        publisherMapper.insert(new PublisherEntity(2L,
                1l, 1, "afdafdasf", "fda", "fdafd"));
        publisherMapper.insert(new PublisherEntity(3L,
                1l, 1, "afdafdasf", "fda", "fdafd"));

        Assert.assertEquals(3, publisherMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<PublisherEntity> publisherEntities = publisherMapper.getAll();
        if (publisherEntities == null || publisherEntities.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(publisherEntities.toString());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        PublisherEntity publisherEntity = publisherMapper.getOne(1l);
        System.out.println(publisherEntity.toString());
        publisherEntity.setGroupName("eaeafea");
        publisherMapper.update(publisherEntity);
        Assert.assertTrue("eaeafea".equals(publisherMapper.getOne(1l).getGroupName()));
    }

    @Test
    public void testPage() {
        JqPage jqPage = new JqPage();
        jqPage.setPage(1);
        jqPage.setPageSize(10);
        jqPage = publisherService.findPublisherEntityPage(jqPage, null);
        System.out.println(JSON.toJSONString(jqPage));
    }

}