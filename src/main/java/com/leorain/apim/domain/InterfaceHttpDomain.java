package com.leorain.apim.domain;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/12 0012.
 */
public class InterfaceHttpDomain implements Serializable {

    /*接口详情*/
    private Long appIdInput;
    private String protocolInput;
    private String methodInput;
    private String transformatInput;
    private String addressInput;
    private String nameInput;
    private String descriptionInput;

    /*请求参数*/
    private List<String> paramNamesInput;
    private List<String> paramTypesInput;
    private List<String> paramDescribesInput;
    private List<Boolean> requiredsInput;
    private List<Boolean> jsontransformatsInput;
    private List<String> examplesInput;
    private List<String> defaultValuesInput;


    /*返回示例*/
    private String returnExampleContent;
    private String returnExampleAttentionMatters;

    /*异常示例*/
    private String exceptionExampleContent;
    private String exceptionAttentionMatters;

    public Long getAppIdInput() {
        return appIdInput;
    }

    public void setAppIdInput(Long appIdInput) {
        this.appIdInput = appIdInput;
    }

    public String getProtocolInput() {
        return protocolInput;
    }

    public void setProtocolInput(String protocolInput) {
        this.protocolInput = protocolInput;
    }

    public String getMethodInput() {
        return methodInput;
    }

    public void setMethodInput(String methodInput) {
        this.methodInput = methodInput;
    }

    public String getTransformatInput() {
        return transformatInput;
    }

    public void setTransformatInput(String transformatInput) {
        this.transformatInput = transformatInput;
    }

    public String getAddressInput() {
        return addressInput;
    }

    public void setAddressInput(String addressInput) {
        this.addressInput = addressInput;
    }

    public String getNameInput() {
        return nameInput;
    }

    public void setNameInput(String nameInput) {
        this.nameInput = nameInput;
    }

    public String getDescriptionInput() {
        return descriptionInput;
    }

    public void setDescriptionInput(String descriptionInput) {
        this.descriptionInput = descriptionInput;
    }

    public List<String> getParamNamesInput() {
        return paramNamesInput;
    }

    public void setParamNamesInput(List<String> paramNamesInput) {
        this.paramNamesInput = paramNamesInput;
    }

    public List<String> getParamTypesInput() {
        return paramTypesInput;
    }

    public void setParamTypesInput(List<String> paramTypesInput) {
        this.paramTypesInput = paramTypesInput;
    }

    public List<String> getParamDescribesInput() {
        return paramDescribesInput;
    }

    public void setParamDescribesInput(List<String> paramDescribesInput) {
        this.paramDescribesInput = paramDescribesInput;
    }

    public List<Boolean> getRequiredsInput() {
        return requiredsInput;
    }

    public void setRequiredsInput(List<Boolean> requiredsInput) {
        this.requiredsInput = requiredsInput;
    }

    public List<Boolean> getJsontransformatsInput() {
        return jsontransformatsInput;
    }

    public void setJsontransformatsInput(List<Boolean> jsontransformatsInput) {
        this.jsontransformatsInput = jsontransformatsInput;
    }

    public List<String> getExamplesInput() {
        return examplesInput;
    }

    public void setExamplesInput(List<String> examplesInput) {
        this.examplesInput = examplesInput;
    }

    public List<String> getDefaultValuesInput() {
        return defaultValuesInput;
    }

    public void setDefaultValuesInput(List<String> defaultValuesInput) {
        this.defaultValuesInput = defaultValuesInput;
    }

    public String getReturnExampleContent() {
        return returnExampleContent;
    }

    public void setReturnExampleContent(String returnExampleContent) {
        this.returnExampleContent = returnExampleContent;
    }

    public String getReturnExampleAttentionMatters() {
        return returnExampleAttentionMatters;
    }

    public void setReturnExampleAttentionMatters(String returnExampleAttentionMatters) {
        this.returnExampleAttentionMatters = returnExampleAttentionMatters;
    }

    public String getExceptionExampleContent() {
        return exceptionExampleContent;
    }

    public void setExceptionExampleContent(String exceptionExampleContent) {
        this.exceptionExampleContent = exceptionExampleContent;
    }

    public String getExceptionAttentionMatters() {
        return exceptionAttentionMatters;
    }

    public void setExceptionAttentionMatters(String exceptionAttentionMatters) {
        this.exceptionAttentionMatters = exceptionAttentionMatters;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
