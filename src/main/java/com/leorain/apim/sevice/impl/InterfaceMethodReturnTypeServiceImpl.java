package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.InterfaceMethodReturnTypeEntity;
import com.leorain.apim.entity.InterfaceMethodReturnTypeEntityRowMapper;
import com.leorain.apim.mapper.InterfaceMethodReturnTypeMapper;
import com.leorain.apim.sevice.InterfaceMethodReturnTypeService;
import com.leorain.apim.tools.JqPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class InterfaceMethodReturnTypeServiceImpl implements InterfaceMethodReturnTypeService {
    @Autowired
    private InterfaceMethodReturnTypeMapper interfaceMethodReturnTypeMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public InterfaceMethodReturnTypeEntity findInterfaceMethodReturnTypeEntity(Long interfaceMethodReturnTypeId) {
        return interfaceMethodReturnTypeMapper.getOne(interfaceMethodReturnTypeId);
    }

    @Override
    public List<InterfaceMethodReturnTypeEntity> findInterfaceMethodReturnTypeEntityList() {
        return interfaceMethodReturnTypeMapper.getAll();
    }

    @Override
    public JqPage<InterfaceMethodReturnTypeEntity> findInterfaceMethodReturnTypeEntityPage(JqPage jqPage,
                                                                                           InterfaceMethodReturnTypeEntity interfaceMethodReturnTypeEntity) {
        String countSQL = " SELECT COUNT(*) FROM T_API_INTERFACE_METHOD_RETURNTYPE ";
        String resultSQL = " SELECT * FROM T_API_INTERFACE_METHOD_RETURNTYPE LIMIT ?, ? ";
        jqPage.setRecords(jdbcTemplate.queryForObject(countSQL, int.class));
        Object[] args = {jqPage.getFromIndex(), jqPage.getPageSize()};
        jqPage.setRows(jdbcTemplate.query(resultSQL, args, new InterfaceMethodReturnTypeEntityRowMapper()));
        return jqPage;
    }
}
