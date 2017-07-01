package com.leorain.apim.sevice.impl;

import com.leorain.apim.entity.PublisherEntity;
import com.leorain.apim.entity.PublisherEntityRowMapper;
import com.leorain.apim.mapper.PublisherMapper;
import com.leorain.apim.sevice.PublisherService;
import com.leorain.apim.tools.JqPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherMapper publisherMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public PublisherEntity findPublisherEntity(Long publisherId) {
        return publisherMapper.getOne(publisherId);
    }

    @Override
    public List<PublisherEntity> findPublisherEntityList() {
        return publisherMapper.getAll();
    }

    @Override
    public JqPage<PublisherEntity> findPublisherEntityPage(JqPage jqPage, PublisherEntity publisherEntity) {
        String countSQL = " SELECT COUNT(*) FROM T_API_PUBLISHER ";
        String resultSQL = " SELECT * FROM T_API_PUBLISHER LIMIT ?, ? ";
        jqPage.setRecords(jdbcTemplate.queryForObject(countSQL, int.class));
        Object[] args = {jqPage.getFromIndex(), jqPage.getPageSize()};
        jqPage.setRows(jdbcTemplate.query(resultSQL, args, new PublisherEntityRowMapper()));
        return jqPage;
    }


}
