package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.InterfaceRequestEntity;
import com.leorain.apim.entity.InterfaceRequestEntityRowMapper;
import com.leorain.apim.mapper.InterfaceRequestMapper;
import com.leorain.apim.sevice.InterfaceRequestService;
import com.leorain.apim.tools.JqPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class InterfaceRequestServiceImpl implements InterfaceRequestService {
    @Autowired
    private InterfaceRequestMapper interfaceRequestMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public InterfaceRequestEntity findInterfaceRequestEntity(Long interfaceRequestId) {
        return interfaceRequestMapper.getOne(interfaceRequestId);
    }

    @Override
    public List<InterfaceRequestEntity> findInterfaceRequestEntityList() {
        return interfaceRequestMapper.getAll();
    }

    @Override
    public JqPage<InterfaceRequestEntity> findInterfaceRequestEntityPage(JqPage jqPage,
                                                                         InterfaceRequestEntity interfaceRequestEntity) {
        String countSQL = " SELECT COUNT(*) FROM T_API_INTERFACE_REQUEST ";
        String resultSQL = " SELECT * FROM T_API_INTERFACE_REQUEST LIMIT ?, ? ";
        jqPage.setRecords(jdbcTemplate.queryForObject(countSQL, int.class));
        Object[] args = {jqPage.getFromIndex(), jqPage.getPageSize()};
        jqPage.setRows(jdbcTemplate.query(resultSQL, args, new InterfaceRequestEntityRowMapper()));
        return jqPage;
    }
}
