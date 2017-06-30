package com.leorain.apim.web;

import com.leorain.apim.entity.ProjectMemberEntity;
import com.leorain.apim.sevice.ProjectMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@RestController
@RequestMapping("/projectMember")
public class ProjectMemberController {

    @Autowired
    private ProjectMemberService projectMemberService;

    /**
     * 根据项目成员ID查询项目成员信息
     *
     * @param projectMemberId
     * @return
     */
    @RequestMapping("/findProjectMember/{projectMemberId}")
    ProjectMemberEntity findProjectMember(@PathVariable("projectMemberId") Long projectMemberId) {
        return projectMemberService.findProjectMemberEntity(projectMemberId);
    }

    /**
     * 查询所有项目成员信息
     *
     * @return
     */
    @RequestMapping("/findProjectMemberList")
    List<ProjectMemberEntity> findProjectMemberList() {
        return projectMemberService.findProjectMemberEntityList();
    }
}
