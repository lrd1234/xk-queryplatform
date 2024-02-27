package com.qp.utils.dto.report.basedto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;

/**
 * 类名称: BaseRequestBodys
 * 类描述:
 * 创建信息: 王银鹤/ 2020/11/16 17:53/ 1.0
 * 修改信息：王银鹤/ 2020/11/16 17:53/ 1.0
 */

@Setter
@Getter
public class BaseRequestBodys<T> {

    /*
     *接收前端headers
     **/
    private  BaseRequest  requestHead;
    /*
     *接收前端bodys对象
     **/
    @Valid
    private  T bodys;
}
