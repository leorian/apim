package com.leorain.apim.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 * 接口出参表
 */
public class InterfaceResponseEntity {

    /**
     * 接口出参ID
     */
    private long interfaceResponseId;

    /**
     * 接口ID
     */
    private long interfaceId;

    /**
     * 场景
     */
    private int scene;

    /**
     * 返回类型
     */
    private int responseReturnMode;

    /**
     * 返回示例
     */
    private String responseExample;

    /**
     * 返回备注
     */
    private String responseRemark;

    public long getInterfaceResponseId() {
        return interfaceResponseId;
    }

    public void setInterfaceResponseId(long interfaceResponseId) {
        this.interfaceResponseId = interfaceResponseId;
    }

    public long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(long interfaceId) {
        this.interfaceId = interfaceId;
    }

    public int getScene() {
        return scene;
    }

    public void setScene(int scene) {
        this.scene = scene;
    }

    public int getResponseReturnMode() {
        return responseReturnMode;
    }

    public void setResponseReturnMode(int responseReturnMode) {
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
