package com.leorain.apim.mapper;

import com.leorain.apim.entity.ProjectEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectMapperTest {

    @Autowired
    private ProjectMapper projectMapper;

    @Test
    public void testInsert() throws Exception {
        projectMapper.insert(new ProjectEntity(1L,
                "java.lang.Integer", "userId", 1l));
        projectMapper.insert(new ProjectEntity(2L,
                "java.lang.Integer", "userId", 1l));
        projectMapper.insert(new ProjectEntity(3L,
                "java.lang.Integer", "userId", 1l));

        Assert.assertEquals(3, projectMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<ProjectEntity> projectEntities = projectMapper.getAll();
        if (projectEntities == null || projectEntities.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(projectEntities.toString());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        ProjectEntity projectEntity = projectMapper.getOne(1l);
        System.out.println(projectEntity.toString());
        projectEntity.setProjectName("ddddd");
        projectMapper.update(projectEntity);
        Assert.assertTrue(("ddddd".equals(projectMapper.getOne(1l).getProjectName())));
    }

}