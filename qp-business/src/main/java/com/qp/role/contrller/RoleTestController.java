package com.qp.role.contrller;

import com.qp.accessControl.AjaxResponse;
import com.qp.accessControl.SectionNote;
import com.qp.model.vo.common.Result;
import com.qp.model.vo.common.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roleTest")
@Slf4j
public class RoleTestController {

    @SectionNote(value = "2")
    @GetMapping("/testRole")
    public AjaxResponse testRole() {
        log.info("有权限进入当前接口");
        System.out.println("有权限，进入此接口");

       return AjaxResponse.success("null");
    }
}
