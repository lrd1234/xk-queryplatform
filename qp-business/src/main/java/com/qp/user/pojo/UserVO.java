package com.qp.user.pojo;

import com.qp.datamasking.ReadableSensitiveTypeEnum;
import com.qp.datamasking.ReadableSensitiveVerify;
import lombok.Data;
@Data
public class UserVO {
        private Long id;
        private String name;
        private Integer age;
        private String email;

}
