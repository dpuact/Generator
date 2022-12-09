package com.bijw.generator.common;

import com.bijw.generator.common.exception.BusinessException;
import com.bijw.generator.common.exception.Results;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shkstart
 * @create 2022-12-05 16:49
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 统一处理业务异常
     *
     * @param e
     * @param <>
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public Results<?> doBusException(BusinessException e) {
        //1、记录错误日志
        //2、返回结果
        return Results.failed(e.getCode(),e.getMessage());
    }

    /**
     * 处理其他异常
     *
     * @param e
     * @param <>
     * @return
     */
    @ExceptionHandler
    public Results<?> doException(Exception e) {
        //1、记录错误日志
        //2、返回结果
        return Results.failed("系统异常，请联系管理员，错误详情：" + e.getMessage());
    }

}