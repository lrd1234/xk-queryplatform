package com.qp.datamasking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 定义枚举类，用于数据脱敏验证
 */
@Getter
@AllArgsConstructor
public enum ReadableSensitiveTypeEnum {

    /**
     * 姓名
     */
    NAME("姓名"),

    /**
     * 邮箱
     */
    EMAIL("邮箱"),

    /**
     * 年龄
     */
    AGE("年龄");

    private String desc;

}
