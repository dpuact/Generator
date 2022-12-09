package com.bijw.generator.common.utils;

import lombok.Getter;

/**
 * @author shkstart
 * @create 2022-12-08 9:34
 */
@Getter
public enum ResultEnum {
    SUCCESS(true,20000,"成功"),
    FAILED(false,20001,"失败"),
    PARAM_ERROR(false,20002,"参数异常");

    // 响应是否成功
    private Boolean success;
    // 响应状态码
    private Integer code;
    // 响应信息
    private String msg;

    ResultEnum(Boolean success, Integer code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }
}
