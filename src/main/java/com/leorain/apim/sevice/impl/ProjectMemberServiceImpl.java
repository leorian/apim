package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.ProjectMemberEntity;
import com.leorain.apim.mapper.ProjectMemberMapper;
import com.leorain.apim.sevice.ProjectMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {

    @Autowired
    private ProjectMemberMapper projectMemberMapper;

    @Override
    public ProjectMemberEntity findProjectMemberEntity(Long projectMemberId) {
        return projectMemberMapper.getOne(projectMemberId);
    }

    @Override
    public List<ProjectMemberEntity> findProjectMemberEntityList() {
        return projectMemberMapper.getAll();
    }
}
