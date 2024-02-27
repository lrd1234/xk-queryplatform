package com.qp.role.PO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePO {
    private String roleId;
    private String roleName;
    private String roleLevel;
}
