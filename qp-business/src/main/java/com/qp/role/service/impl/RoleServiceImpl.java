package com.qp.role.service.impl;

import com.qp.role.mapper.RoleMapper;
import com.qp.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl implements RoleService {
   @Autowired
    RoleMapper roleMapper;
    @Override
    public String getUserRoleUserId(String userId) {
        String roleLevel = roleMapper.getUserRoleUserId(userId);
        return roleLevel;
    }
}
