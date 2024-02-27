package com.qp;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.qp.*")
public class QueryPlatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(QueryPlatformApplication.class,args);
        log.info("***********QueryPlatformApplication启动成功*******");
    }
}
