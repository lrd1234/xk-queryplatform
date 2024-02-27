package com.qp.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiHui
 * @create 2024-02-19-16:49
 * @date 2024/2/19-16:49
 */
@Slf4j
@RestController
@RequestMapping("/ping")
public class Ping {
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String ping(){
        String success="绿灯成功";
        log.info(success);
        return  success;
    }
}
