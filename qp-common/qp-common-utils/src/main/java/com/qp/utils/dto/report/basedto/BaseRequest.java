package com.qp.utils.dto.report.basedto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
/**
 * @ClassName: BaseRequest
 * @Description: 接收前端heder请求参数
 * @author magy
 * @date 2019/7/12 16:40
 * @version : V1.0
 */
public  class BaseRequest {
    /** 交易流水号 GUID*/
    private	 String  transNo;

    /** 渠道编码 柜面固定为00*/
    private	String	salechnl;

    /** 交易编码 */
    private	String	TransCode;

    /** 请求日期 */
    private Date RequestDate;

    /** 请求时间 */
    private	String	RequestTime;

    /** 备用字段一 */
    private	String	standbyflag1;

    /** 备用字段二*/
    private	String	standbyflag2;

    /** 备用字段三*/
    private	String	standbyflag3;



}
