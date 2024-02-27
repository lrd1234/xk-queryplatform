package com.qp.utils.dto.report.basedto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;

@Setter
@Getter
/**
 * @ClassName: RequestBodys
 * @Description: 接收前端请求对象
 * @author magy
 * @date 2019/7/12 16:40
 * @version : V1.0
 */
public class RequestBodys<T> {
    /*
     *接收前端headers
     **/
    private  BaseRequest  headers;
    /*
     *接收前端bodys对象
     **/
    @Valid
    private  T bodys;


}
