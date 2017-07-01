package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.InterfaceEntity;
import com.leorain.apim.entity.InterfaceEntityRowMapper;
import com.leorain.apim.mapper.InterfaceMapper;
import com.leorain.apim.sevice.InterfaceService;
import com.leorain.apim.tools.JqPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class InterfaceServiceImpl implements InterfaceService {
    @Autowired
    private InterfaceMapper interfaceMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public InterfaceEntity findInterfaceEntity(Long interfaceId) {
        return interfaceMapper.getOne(interfaceId);
    }

    @Override
    public List<InterfaceEntity> findInterfaceEntityList() {
        return interfaceMapper.getAll();
    }

    @Override
    public JqPage<InterfaceEntity> findInterfaceEntityPage(JqPage jqPage, InterfaceEntity interfaceEntity) {
        String countSQL = " SELECT COUNT(*) FROM T_API_INTERFACE ";
        String resultSQL = " SELECT * FROM T_API_INTERFACE LIMIT ?, ? ";
        jqPage.setRecords(jdbcTemplate.queryForObject(countSQL, int.class));
        Object[] args = {jqPage.getFromIndex(), jqPage.getPageSize()};
        jqPage.setRows(jdbcTemplate.query(resultSQL, args, new InterfaceEntityRowMapper()));
        return jqPage;
    }
}
