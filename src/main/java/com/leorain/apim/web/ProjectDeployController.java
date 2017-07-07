package com.leorain.apim.web;

import com.leorain.apim.domain.ProjectDeployDomain;
import com.leorain.apim.domain.ResultDomain;
import com.leorain.apim.sevice.ProjectDeployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
