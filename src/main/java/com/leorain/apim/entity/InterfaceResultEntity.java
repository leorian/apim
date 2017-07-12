package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/7/12 0012.
 */
public class InterfaceResultEntity extends BaseEntity {

    /**
     * 接口返回示例ID
     */
    private Long id;

    /**
     * 接口ID
     */
    private Long interfaceId;

    /**
     * 接口类型
     */
    private String interfaceType;

    /**
     * 示例类型
     */
    private String exampleType;

    /**
     * 示例内容
     */
    private String exampleContent;

    /**
     * 注意事项
     */
    private String attentionMatters;


    public InterfaceResultEntity() {
    }

    public InterfaceResultEntity(Long id, Long interfaceId, String interfaceType,
                                 String exampleType, String exampleContent, String attentionMatters) {
        this.id = id;
        this.interfaceId = interfaceId;
        this.interfaceType = interfaceType;
        this.exampleType = exampleType;
        this.exampleContent = exampleContent;
        this.attentionMatters = attentionMatters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Long interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getExampleType() {
        return exampleType;
    }

    public void setExampleType(String exampleType) {
        this.exampleType = exampleType;
    }

    public String getExampleContent() {
        return exampleContent;
    }

    public void setExampleContent(String exampleContent) {
        this.exampleContent = exampleContent;
    }

    public String getAttentionMatters() {
        return attentionMatters;
    }

    public void setAttentionMatters(String attentionMatters) {
        this.attentionMatters = attentionMatters;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
