package com.leorain.apim.web;

import com.leorain.apim.entity.PublisherEntity;
import com.leorain.apim.sevice.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
@RestController
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    /**
     * 根据发布ID查询发布信息
     *
     * @param publisherId
     * @return
     */
    @RequestMapping("/findPublisher/{publisherId}")
    public PublisherEntity findPublisher(@PathVariable("publisherId") Long publisherId) {
        return publisherService.findPublisherEntity(publisherId);
    }

    /**
     * 查询所有的发布信息
     *
     * @return
     */
    @RequestMapping("/findPublisherList")
    public List<PublisherEntity> findPublisherList() {
        return publisherService.findPublisherEntityList();
    }
}
