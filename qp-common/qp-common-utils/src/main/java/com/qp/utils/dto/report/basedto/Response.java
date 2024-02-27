package com.qp.utils.dto.report.basedto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
/**
 * @ClassName: Response
 * @Description: 分页返回前端bodys
 * @author magy
 * @date 2019/7/12 16:40
 * @version : V1.0
 */
public class Response<T> {

    /** 数据总量 */
    private  Integer total;

    /** 返回数据数量 */
    private  Integer size;

    /** rows返回数据实体 */
    private List<T> rows;

}
