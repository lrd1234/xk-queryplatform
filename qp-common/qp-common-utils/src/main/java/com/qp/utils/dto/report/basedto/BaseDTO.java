package com.qp.utils.dto.report.basedto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * @ClassName: AbstractController
 * @Description: 不分页返回前端DTO
 * @author magy
 * @date 2019/7/12 16:40
 * @version : V1.0
 */
public class BaseDTO<T> {

    /** 返回前端bodys */
    private  T  bodys;

    /** 返回前端实体header */
    private BaseResponse header;

}
