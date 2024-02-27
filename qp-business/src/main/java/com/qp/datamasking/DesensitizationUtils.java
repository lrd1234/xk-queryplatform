package com.qp.datamasking;

import org.springframework.util.StringUtils;

/**
 * 脱敏工具类，先只验证姓名和邮箱得脱敏，后续根据实际需求
 */
public class DesensitizationUtils {

    /**
     * @description: 名字脱敏
     * 脱敏规则: 仅保留姓，剩余不管多少字符均用*替代，比如刘小五-->刘*，张三-->张*

     */
    public static String desensitizedName(String fullName) {
        if (!StringUtils.isEmpty(fullName) && null != fullName) {
            int length = fullName.length();
                fullName = fullName.substring(0,1)+"*";
        }
        return fullName;
    }

    /**
     *
     * @param email
     * @return 脱敏规则：@位置之前使用***替代，其余保留
     */
    public static String desensitizedEmail(String email) {
        if (!StringUtils.isEmpty(email) && null != email) {
            int length = email.length();
             email = "***"+email.substring(email.indexOf("@"));
        }
        return email;
    }
}

