package com.leorain.apim.mapper;

import com.leorain.apim.entity.ProjectDeployEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectDeployMapperTest {

    @Autowired
    private ProjectDeployMapper projectDeployMapper;

    @Test
    public void testInsert() throws Exception {
        projectDeployMapper.insert(new ProjectDeployEntity(1l, 1l, "用户接口",
                "1",  1,"1"));
        projectDeployMapper.insert(new ProjectDeployEntity(2l, 1l, "用户接口",
                "1",  1,"1"));
        projectDeployMapper.insert(new ProjectDeployEntity(3l, 1l, "用户接口",
                "1",  1,"1"));

        Assert.assertEquals(3, projectDeployMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<ProjectDeployEntity> projectDeployEntities = projectDeployMapper.getAll();
        if (projectDeployEntities == null || projectDeployEntities.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(projectDeployEntities.toString());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        ProjectDeployEntity projectDeployEntity = projectDeployMapper.getOne(1l);
        System.out.println(projectDeployEntity.toString());
        projectDeployEntity.setEnv("hello");
        projectDeployEntity.setUpdateDateTime(new Date());
        projectDeployMapper.update(projectDeployEntity);
        Assert.assertTrue(("hello".equals(projectDeployMapper.getOne(1l).getEnv())));
    }
}