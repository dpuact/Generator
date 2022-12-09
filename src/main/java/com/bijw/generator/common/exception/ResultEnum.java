package com.bijw.generator.common.exception;

/**
 * @author shkstart
 * @create 2022-12-05 9:33
 */
//常用结果的枚举
public enum ResultEnum implements IResult{
    SUCCESS(2001, "接口调用成功"),
    VALIDATE_FAILED(2002, "参数校验失败"),
    COMMON_FAILED(2003, "接口调用失败"),
    FORBIDDEN(2004, "没有权限访问资源");


    ResultEnum(int i, String 接口调用成功) {
    }

    @Override
    public Integer getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }

    //省略get、set方法和构造方法
}