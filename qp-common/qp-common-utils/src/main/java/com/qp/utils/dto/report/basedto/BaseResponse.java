package com.qp.utils.dto.report.basedto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
/**
 * @ClassName: BaseResponse
 * @Description: 返回前端heders参数
 * @author magy
 * @date 2019/7/12 16:40
 * @version : V1.0
 */
public   class BaseResponse {
    /** 交易流水号 GUID*/
    private	String  transNo;

    /*渠道编码 柜面固定为00*/
    private	String	salechnl;

    /** 交易编码 */
    private	String	TransCode;

    /** 请求日期 */
    private Date RequestDate;

    /** 请求时间 */
    private String RequestTime;

    /** 返回日期 */
    private Date ResponseDate;

    /** 返回时间 */
    private	String	ResponseTime;

    /** 备用字段1 */
    private	String	Standbyflag1;

    /** 备用字段2*/
    private	String	Standbyflag2;

    /** 备用字段3 */
    private	String	Standbyflag3;

    /** code服务处理状态(200:处理成功, 500:服务器出错)*/
    private	String	code;

    /** success业务逻辑状态(true:处理成功, false:处理失败)*/
    private	boolean	success;

    /** message返回消息(比如:数据保存成功)*/
    private	String	message;



}
