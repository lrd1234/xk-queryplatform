package com.qp.role.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface RoleMapper {
     String getUserRoleUserId(String userId);
}
