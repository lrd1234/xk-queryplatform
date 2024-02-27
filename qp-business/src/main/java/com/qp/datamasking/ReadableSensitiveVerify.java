package com.qp.datamasking;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义注解，用于哪些字段需要脱敏，即字段加上了这个注解，则当前字段需要由脱敏规则脱敏后展示
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ReadableSensitiveVerify {

    // 记录需要加密的参数位置,这个加密位置没用到，其实可以配置加密类型，即实体类中得哪个字段需要被加密
    int value();

}

