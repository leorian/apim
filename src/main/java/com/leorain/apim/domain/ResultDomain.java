package com.leorain.apim.domain;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * Created by xiezg@317hu.com on 2017/7/6 0006.
 */
public class ResultDomain implements Serializable {
    private boolean success = true;
    private String errorCode;
    private String errorMsg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
