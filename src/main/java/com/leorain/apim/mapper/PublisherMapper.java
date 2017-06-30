package com.leorain.apim.mapper;

import com.leorain.apim.entity.PublisherEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface PublisherMapper {
    List<PublisherEntity> getAll();

    PublisherEntity getOne(Long id);

    void insert(PublisherEntity publisherEntity);

    void update(PublisherEntity publisherEntity);

    void delete(Long id);
}
