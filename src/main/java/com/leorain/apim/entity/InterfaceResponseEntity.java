package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 接口出参表
 */
public class InterfaceResponseEntity extends BaseEntity {

    /**
     * 接口出参ID
     */
    private Long interfaceResponseId;

    /**
     * 接口ID
     */
    private Long interfaceId;

    /**
     * 场景
     */
    private Integer scene;

    /**
     * 返回类型
     */
    private Integer responseReturnMode;

    /**
     * 返回示例
     */
    private String responseExample;

    /**
     * 返回备注
     */
    private String responseRemark;

    public Long getInterfaceResponseId() {
        return interfaceResponseId;
    }

    public void setInterfaceResponseId(Long interfaceResponseId) {
        this.interfaceResponseId = interfaceResponseId;
    }

    public Long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Long interfaceId) {
        this.interfaceId = interfaceId;
    }

    public Integer getScene() {
        return scene;
    }

    public void setScene(Integer scene) {
        this.scene = scene;
    }

    public Integer getResponseReturnMode() {
        return responseReturnMode;
    }

    public void setResponseReturnMode(Integer responseReturnMode) {
        this.responseReturnMode = responseReturnMode;
    }

    public String getResponseExample() {
        return responseExample;
    }

    public void setResponseExample(String responseExample) {
        this.responseExample = responseExample;
    }

    public String getResponseRemark() {
        return responseRemark;
    }

    public void setResponseRemark(String responseRemark) {
        this.responseRemark = responseRemark;
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
