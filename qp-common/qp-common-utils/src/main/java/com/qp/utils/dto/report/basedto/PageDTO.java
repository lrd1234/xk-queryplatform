package com.qp.utils.dto.report.basedto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * @ClassName: PageDTO
 * @Description: 分页返回前端DTO
 * @author magy
 * @date 2019/7/12 16:40
 * @version : V1.0
 */
public class PageDTO<T>  {
    /*
     *返回前端bodys
     **/
    private  Response<T>  bodys;

    /*
     *返回前端headers
     **/
    private BaseResponse headers;



}
