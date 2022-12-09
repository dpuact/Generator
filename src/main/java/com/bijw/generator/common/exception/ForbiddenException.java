package com.bijw.generator.common.exception;

/**
 * @author shkstart
 * @create 2022-12-05 9:54
 */
//自定义异常
public class ForbiddenException extends RuntimeException{
    public ForbiddenException(String message) {
        super(message);
    }
}
