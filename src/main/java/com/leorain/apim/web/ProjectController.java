package com.leorain.apim.web;

import com.leorain.apim.entity.ProjectEntity;
import com.leorain.apim.sevice.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/findProject/{projectId}")
    ProjectEntity findProject(@PathVariable("projectId") Long projectId) {
        return projectService.findProjectEntity(projectId);
    }

    @RequestMapping("/findProjectList")
    List<ProjectEntity> findProjectList() {
        return projectService.findProjectEntityList();
    }


}
