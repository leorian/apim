package com.leorain.apim.sevice.impl;

import com.leorain.apim.mapper.PublisherMapper;
import com.leorain.apim.sevice.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherMapper publisherMapper;
}
