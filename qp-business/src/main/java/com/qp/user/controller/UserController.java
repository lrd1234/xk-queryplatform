package com.qp.user.controller;

import cn.hutool.json.JSONUtil;
import com.qp.datamasking.ReadableSensitiveVerify;
import com.qp.model.entity.user.User;
import com.qp.model.vo.common.Result;
import com.qp.model.vo.common.ResultCodeEnum;
import com.qp.user.mapper.UserMapper;
import com.qp.user.pojo.UserVO;
import com.qp.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LiHui
 * @create 2024-02-20-9:42
 * @date 2024/2/20-9:42
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping(value = "/getUserCount",method = RequestMethod.POST)
    public Result getUserCount(){
        String k2="k2";
        long count=userService.count();
            redisTemplate.opsForValue().set(k2,count);
            log.info("count存："+count);
            long l=(Long)redisTemplate.opsForValue().get(k2);
        log.info("count取："+l);
        return Result.build(count, ResultCodeEnum.SUCCESS);

    }

    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    public Result getUserList(){
        List<User> userList=userService.list();

        String k2="k2";
        long l=(Long)redisTemplate.opsForValue().get(k2);
        log.info("count取："+l);

        return Result.build(userList,ResultCodeEnum.SUCCESS);

    }

    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    @ReadableSensitiveVerify(value = 1 )

    public UserVO getAllUser(int age){
        log.info("进入age = 28 用户接口");
        UserVO user = userMapper.getUser(28);
        return user;

    }
}
