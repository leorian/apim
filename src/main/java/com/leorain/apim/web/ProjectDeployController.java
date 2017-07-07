package com.leorain.apim.web;

import com.leorain.apim.domain.ProjectDeployDomain;
import com.leorain.apim.domain.ResultDomain;
import com.leorain.apim.entity.ProjectDeployEntity;
import com.leorain.apim.sevice.ProjectDeployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/7 0007.
 */
@RestController
@RequestMapping("/projectDeploy")
public class ProjectDeployController {
    @Autowired
    private ProjectDeployService projectDeployService;

    /**
     * 新增机器信息
     *
     * @return
     */
    @RequestMapping("/insertProjectDeploy")
    public ResultDomain insertProjectDeploy(ProjectDeployDomain projectDeployDomain) {
        projectDeployService.insertProjectDeployEntity(projectDeployDomain.buildProjectDeployEntity());
        return new ResultDomain();
    }

    /**
     * 更新机器信息
     *
     * @param projectDeployDomain
     * @param deployId
     * @return
     */
    @RequestMapping("/updateProjectDeploy")
    public ResultDomain updateProjectDeploy(ProjectDeployDomain projectDeployDomain,
                                            @RequestParam("deployIdInput") Long deployId) {
        projectDeployService.updateProjectDeployEntity(projectDeployDomain.buildProjectDeployEntity(), deployId);
        return new ResultDomain();
    }

    /**
     * 根据机器ID查询机器信息
     *
     * @return
     */
    @RequestMapping("/findProjectDeploy/{deployId}")
    public ProjectDeployEntity findProjectDeploy(@PathVariable("deployId") Long deployId) {
        return projectDeployService.findProjectDeployEntity(deployId);
    }

    /**
     * 根据项目ID获取机器列表信息
     *
     * @param projectId
     * @return
     */
    @RequestMapping("/findProjectDeployList/{projectId}")
    public List<ProjectDeployEntity> findProjectDeployList(@PathVariable("projectId") Long projectId) {
        return projectDeployService.getProjectDeployEntityListByProjectId(projectId);
    }

    /**
     * 删除机器信息
     *
     * @param deployId
     * @return
     */
    @RequestMapping("/deleteProjectDeploy")
    public ResultDomain deleteProjectDeploy(@RequestParam("deployId") Long deployId) {
        projectDeployService.deleteProjectDeployEntity(deployId);
        return new ResultDomain();
    }

    ;
}
