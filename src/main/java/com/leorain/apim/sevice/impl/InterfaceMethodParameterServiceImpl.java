package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.InterfaceMethodParameterEntity;
import com.leorain.apim.entity.InterfaceMethodParameterEntityRowMapper;
import com.leorain.apim.mapper.InterfaceMethodParameterMapper;
import com.leorain.apim.sevice.InterfaceMethodParameterService;
import com.leorain.apim.tools.JqPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class InterfaceMethodParameterServiceImpl implements InterfaceMethodParameterService {

    @Autowired
    private InterfaceMethodParameterMapper interfaceMethodParameterMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public InterfaceMethodParameterEntity findInterfaceMethodParameterEntity(Long interfaceMethodParameterId) {
        return interfaceMethodParameterMapper.getOne(interfaceMethodParameterId);
    }

    @Override
    public List<InterfaceMethodParameterEntity> findInterfaceMethodParameterEntityList() {
        return interfaceMethodParameterMapper.getAll();
    }

    @Override
    public JqPage<InterfaceMethodParameterEntity> findInterfaceMethodParameterEntityPage(JqPage jqPage,
                                                                                         InterfaceMethodParameterEntity interfaceMethodParameterEntity) {
        String countSQL = " SELECT COUNT(*) FROM T_API_INTERFACE_METHOD_PARAMETER ";
        String resultSQL = " SELECT * FROM T_API_INTERFACE_METHOD_PARAMETER LIMIT ? , ? ";
        jqPage.setRecords(jdbcTemplate.queryForObject(countSQL, int.class));
        Object[] args = {jqPage.getFromIndex(), jqPage.getPageSize()};
        jqPage.setRows(jdbcTemplate.query(resultSQL, args, new InterfaceMethodParameterEntityRowMapper()));
        return jqPage;
    }
}
