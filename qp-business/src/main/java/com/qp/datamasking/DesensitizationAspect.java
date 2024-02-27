package com.qp.datamasking;


import com.qp.model.entity.user.User;
import com.qp.model.vo.common.Result;
import com.qp.model.vo.common.ResultCodeEnum;
import com.qp.user.mapper.UserMapper;
import com.qp.user.pojo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 返回值数据脱敏处理aop

 */
@Slf4j
@Component
@Aspect
public class DesensitizationAspect {
    @Autowired
    UserMapper userMapper;

    /**
     * @description: 切入点
     */
    @Pointcut("execution(* com.qp.*.controller.*.*(..)) && @annotation(com.qp.datamasking.ReadableSensitiveVerify)")
    public void mask() {
    }


    @AfterReturning(returning = "data", pointcut = "mask()")
    private Object around(JoinPoint pjp, Object data) throws Throwable {
        // 得到方法执行所需的参数
        Object[] args = pjp.getArgs();
        log.info("获取执行参数：{}",args);
        UserVO users = (UserVO)data;
        log.info("获取将要加密得users:{}",users);
        ReadableSensitiveVerify encryptParam = ((MethodSignature) pjp.getSignature()).getMethod().getAnnotation(ReadableSensitiveVerify.class);
        log.info("获取加密位置：{}",encryptParam);
        // 获取需要加密的参数位置
        int index = encryptParam.value();
        log.info("加密位置："+index);
        // 对参数进行处理
        users.setName(DesensitizationUtils.desensitizedName(users.getName()));
        log.info("脱敏后：{}",users);

        return Result.build(users, ResultCodeEnum.SUCCESS);
    }



}