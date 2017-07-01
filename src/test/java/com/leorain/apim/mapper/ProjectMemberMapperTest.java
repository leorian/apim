package com.leorain.apim.mapper;

import com.alibaba.fastjson.JSON;
import com.leorain.apim.entity.ProjectMemberEntity;
import com.leorain.apim.sevice.ProjectMemberService;
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
public class ProjectMemberMapperTest {

    @Autowired
    private ProjectMemberMapper projectMemberMapper;

    @Autowired
    private ProjectMemberService projectMemberService;

    @Test
    public void testInsert() throws Exception {
        projectMemberMapper.insert(new ProjectMemberEntity(1L,
                1l, 1l));
        projectMemberMapper.insert(new ProjectMemberEntity(2L,
                1l, 1l));
        projectMemberMapper.insert(new ProjectMemberEntity(3L,
                1l, 1l));

        Assert.assertEquals(3, projectMemberMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<ProjectMemberEntity> projectMemberEntities = projectMemberMapper.getAll();
        if (projectMemberEntities == null || projectMemberEntities.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(projectMemberEntities.toString());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        ProjectMemberEntity projectMemberEntity = projectMemberMapper.getOne(1l);
        System.out.println(projectMemberEntity.toString());
        projectMemberEntity.setProjectMemberId(1l);
        projectMemberMapper.update(projectMemberEntity);
        Assert.assertTrue(1l == projectMemberMapper.getOne(1l).getProjectMemberId());
    }

    @Test
    public void testPage() {
        JqPage jqPage = new JqPage();
        jqPage.setPage(1);
        jqPage.setPageSize(10);
        jqPage = projectMemberService.findProjectMemberEntityPage(jqPage, null);
        System.out.println(JSON.toJSONString(jqPage));
    }

}