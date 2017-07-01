package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.InterfaceMethodEntity;
import com.leorain.apim.entity.InterfaceMethodEntityRowMapper;
import com.leorain.apim.mapper.InterfaceMethodMapper;
import com.leorain.apim.sevice.InterfaceMethodService;
import com.leorain.apim.tools.JqPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class InterfaceMethodServiceImpl implements InterfaceMethodService {

    @Autowired
    private InterfaceMethodMapper interfaceMethodMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public InterfaceMethodEntity findInterfaceMethodEntity(Long interfaceMethodId) {
        return interfaceMethodMapper.getOne(interfaceMethodId);
    }

    @Override
    public List<InterfaceMethodEntity> findInterfaceMethodEntityList() {
        return interfaceMethodMapper.getAll();
    }

    @Override
    public JqPage<InterfaceMethodEntity> findInterfaceMethodEntityPage(JqPage jqPage, InterfaceMethodEntity interfaceMethodEntity) {
        String countSQL = " SELECT COUNT(*) FROM T_API_INTERFACE_METHOD ";
        String resultSQL = " SELECT * FROM T_API_INTERFACE_METHOD LIMIT ?, ? ";
        jqPage.setRecords(jdbcTemplate.queryForObject(countSQL, int.class));
        Object[] args = {jqPage.getFromIndex(), jqPage.getPageSize()};
        jqPage.setRows(jdbcTemplate.query(resultSQL, args, new InterfaceMethodEntityRowMapper()));
        return jqPage;
    }
}
