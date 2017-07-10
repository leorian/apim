package com.leorain.apim.mongodb.exception;

/**
 * Created by xiezg@317hu.com on 2017/1/5 0005.
 */
public enum ConfigCenterCodeEnum {

    T1001("FAILURE", "应用不能为空"),
    T1002("FAILURE", "应用运行环境不能为空"),
    T1003("FAILURE", "请填入配置信息（格式：属性名=属性值 或者 属性名:属性值）!"),
    T1004("SUCCESS", "提交成功！"),
    T1005("SUCCESS", "删除成功！"),
    T1006("FAILURE", "更新失败,未找到相关Key！"),
    T1007("SUCCESS", "更新成功！"),
    T1008("FAILURE", "加载配置信息时验权失败！"),
    T1009("FAILURE", "选择LDAP应用权限验权失败！"),
    T1010("FAILURE", "LDAP账号不能为空！"),
    T1011("FAILURE", "LDAP账号未关联任何应用"),
    T1012("FAILURE", "应用部署环境服务器信息为空！"),
    T1013("FAILURE", "应用部署环境配置项信息为空！"),
    T1014("FAILURE", "加载应用运行环境信息时验权失败！"),
    T1015("FAILURE", "应用运行环境IP地址不能为空");
    private String code;
    private String msg;

    ConfigCenterCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":\"" + code + '\"' +
                ", \"msg\":\"" + msg + '\"' +
                '}';
    }
}
