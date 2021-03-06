package com.leorain.apim.sevice;

import com.leorain.apim.entity.PublisherEntity;
import com.leorain.apim.tools.JqPage;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public interface PublisherService {

    /**
     * 根据发布ID查找发布信息
     *
     * @param publisherId
     * @return
     */
    PublisherEntity findPublisherEntity(Long publisherId);

    /**
     * 查询所有发布信息列表
     *
     * @return
     */
    List<PublisherEntity> findPublisherEntityList();

    /**
     * 分页查询
     *
     * @param jqPage
     * @param publisherEntity
     * @return
     */
    JqPage<PublisherEntity> findPublisherEntityPage(JqPage jqPage, PublisherEntity publisherEntity);
}
