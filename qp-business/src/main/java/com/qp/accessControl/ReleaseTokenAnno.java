package com.qp.accessControl;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Slf4j
public class ReleaseTokenAnno {
    @Pointcut("@annotation(com.qp.accessControl.ReleaseToken)")
    private void cut() {
    }
    @Before("cut()")
    public void before() {
        log.info("放行接口");
    }
}
