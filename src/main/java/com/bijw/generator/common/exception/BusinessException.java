package com.bijw.generator.common.exception;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

/**
 * @author shkstart
 * @create 2022-12-05 9:55
 */
@Data
public class BusinessException extends RuntimeException{
//    public BusinessException(String message) {
//        super(message);
//    }

    //异常错误码
    private Integer code;
    //错误扩展信息
    private T data;

    public BusinessException(String msg) {
        this(null, msg);
    }

    public BusinessException(Integer code, String msg) {
        this(code, msg, null);
    }

    public BusinessException(Integer code, String msg, T data) {
        super(msg);
        this.code = code;
        this.data = data;
    }


    public static void throwBusException(String msg) {
        throwBusException(null, msg);
    }

    public static void throwBusException(Integer code, String msg) {
        throwBusException(code, msg, null);
    }

    public static void throwBusException(Integer code, String msg, T data) {
        throw new BusinessException(code, msg, data);
    }

}
