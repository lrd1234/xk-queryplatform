package com.qp.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qp.model.entity.user.User;
import com.qp.user.mapper.UserMapper;
import com.qp.user.pojo.UserVO;
import com.qp.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author LiHui
 * @create 2024-02-20-9:49
 * @date 2024/2/20-9:49
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
