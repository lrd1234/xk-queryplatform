package com.qp.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qp.model.entity.user.User;
import com.qp.user.pojo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * @author LiHui
 * @create 2024-02-20-9:47
 * @date 2024/2/20-9:47
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    UserVO  getUser(int age);
}
