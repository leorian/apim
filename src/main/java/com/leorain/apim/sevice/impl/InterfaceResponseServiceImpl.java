package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.InterfaceResponseEntity;
import com.leorain.apim.entity.InterfaceResponseEntityRowMapper;
import com.leorain.apim.mapper.InterfaceResponseMapper;
import com.leorain.apim.sevice.InterfaceResponseService;
import com.leorain.apim.tools.JqPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class InterfaceResponseServiceImpl implements InterfaceResponseService {
    @Autowired
    private InterfaceResponseMapper interfaceResponseMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public InterfaceResponseEntity findInterfaceResponseEntity(Long interfaceResponseId) {
        return interfaceResponseMapper.getOne(interfaceResponseId);
    }

    @Override
    public List<InterfaceResponseEntity> findInterfaceResponseEntityList() {
        return interfaceResponseMapper.getAll();
    }

    @Override
    public JqPage<InterfaceResponseEntity> findInterfaceResponseEntityPage(JqPage jqPage,
                                                                           InterfaceResponseEntity interfaceResponseEntity) {
        String countSQL = " SELECT COUNT(*) FROM T_API_INTERFACE_RESPONSE ";
        String resultSQL = " SELECT * FROM T_API_INTERFACE_RESPONSE LIMIT ?, ? ";
        jqPage.setRecords(jdbcTemplate.queryForObject(countSQL, int.class));
        Object[] args = {jqPage.getFromIndex(), jqPage.getPageSize()};
        jqPage.setRows(jdbcTemplate.query(resultSQL, args, new InterfaceResponseEntityRowMapper()));
        return jqPage;
    }
}
