package com.leorain.apim.web;

import com.leorain.apim.domain.ProjectDomain;
import com.leorain.apim.domain.ResultDomain;
import com.leorain.apim.entity.ProjectEntity;
import com.leorain.apim.entity.ProjectMemberEntity;
import com.leorain.apim.sevice.ProjectMemberService;
import com.leorain.apim.sevice.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectMemberService projectMemberService;

    /**
     * 查询单个项目信息
     *
     * @param projectId
     * @return
     */
    @RequestMapping("/findProject/{projectId}")
    public ProjectEntity findProject(@PathVariable("projectId") Long projectId) {
        return projectService.findProjectEntity(projectId);
    }

    /**
     * 查询所有项目信息
     *
     * @return
     */
    @RequestMapping("/findProjectList")
    public List<ProjectEntity> findProjectList() {
        return projectService.findProjectEntityList();
    }


    /**
     * 新增项目信息
     *
     * @param projectDomain
     * @return
     */
    @RequestMapping("/insertProject")
    public ResultDomain insertProject(ProjectDomain projectDomain) {
        ProjectEntity projectEntity = projectDomain.buildProjectEntity();
        List<ProjectMemberEntity> projectMemberEntityList = projectDomain.buildProjectMemberEntity(projectEntity.getProjectId());
        projectService.insertProject(projectEntity);
        if (!CollectionUtils.isEmpty(projectMemberEntityList)) {
            for (ProjectMemberEntity projectMemberEntity : projectMemberEntityList) {
                projectMemberService.insertProjectMemberEntity(projectMemberEntity);
            }
        }
        return new ResultDomain();
    }

}
