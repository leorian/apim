package com.leorain.apim.mongodb.util;

import com.leorain.apim.mongodb.domain.ConfigSet;
import com.leorain.apim.mongodb.domain.DefineConfigSet;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by xiezg@317hu.com on 2017/1/4 0004.
 */
public class LDAPUtil {

    public static final String CONFIG_CENTER_USERNAME_PREFIX = "CONFIG_CENTER_USERNAME_PREFIX_";

    public static boolean verifySHA(String ldappw, String inputpw) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        if (ldappw.startsWith("{SSHA}") || ldappw.startsWith("{ssha}")) {
            ldappw = ldappw.substring(6);
        } else if (ldappw.startsWith("{SHA}") || ldappw.startsWith("{sha}")) {
            ldappw = ldappw.substring(5);
        }

        byte[] ldappwbyte = Base64.decode(ldappw);
        byte[] shacode;
        byte[] salt;
        if (ldappwbyte.length <= 20) {
            shacode = ldappwbyte;
            salt = new byte[0];
        } else {
            shacode = new byte[20];
            salt = new byte[ldappwbyte.length - 20];
            System.arraycopy(ldappwbyte, 0, shacode, 0, 20);
            System.arraycopy(ldappwbyte, 20, salt, 0, salt.length);
        }

        md.update(inputpw.getBytes());
        md.update(salt);
        byte[] inputpwbyte = md.digest();

        return MessageDigest.isEqual(shacode, inputpwbyte);
    }

    /**
     * 应用运行环境配置项转换工作
     *
     * @param appProperties
     * @return
     */
    public static List<ConfigSet> translateConfigSetFromAppProperties(String appProperties) {
        List<ConfigSet> configSetList = new ArrayList<ConfigSet>();
        if (!StringUtils.isEmpty(appProperties)) {
            String[] keyValues = appProperties.split("\r\n");
            for (String keyValue : keyValues) {
                if (keyValue.startsWith("#")) {
                    continue;
                }
                String split = "=";
                String[] kv = keyValue.split(split);
                if (kv.length < 2) {
                    split = ":";
                    kv = keyValue.split(split);
                    if (kv.length < 2) {
                        continue;
                    }
                }

                ConfigSet configSet = new ConfigSet();
                configSet.setKey(kv[0].trim());
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 1; i < kv.length; i++) {
                    stringBuffer.append(kv[i]);
                    if (i != kv.length - 1) {
                        stringBuffer.append(split);
                    }
                }
                configSet.setValue(stringBuffer.toString().trim());
                configSetList.add(configSet);
            }
        }

        return configSetList;
    }

    /**
     * 应用运行环境自定义配置项转换
     *
     * @param appProperties
     * @return
     */
    public static List<DefineConfigSet> translateDefineConfigSetFromAppProperties(String appProperties) {
        List<DefineConfigSet> defineConfigSetList = new ArrayList<DefineConfigSet>();
        if (!StringUtils.isEmpty(appProperties)) {
            String[] keyValues = appProperties.split("\r\n");
            for (String keyValue : keyValues) {
                if (keyValue.startsWith("#")) {
                    continue;
                }
                String split = "=";
                String[] kv = keyValue.split(split);
                if (kv.length < 2) {
                    split = ":";
                    kv = keyValue.split(split);
                    if (kv.length < 2) {
                        continue;
                    }
                }

                DefineConfigSet defineConfigSet = new DefineConfigSet();
                defineConfigSet.setKey(kv[0].trim());
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 1; i < kv.length; i++) {
                    stringBuffer.append(kv[i]);
                    if (i != kv.length - 1) {
                        stringBuffer.append(split);
                    }
                }
                defineConfigSet.setValue(stringBuffer.toString().trim());
                defineConfigSetList.add(defineConfigSet);
            }
        }

        return defineConfigSetList;
    }
}
