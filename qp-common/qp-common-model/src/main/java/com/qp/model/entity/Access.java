package com.qp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 权限控制类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Access {
    private BigDecimal qp_access_ctrl_cfg_pid;
    //private String
}
