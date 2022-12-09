package com.bijw.generator.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shkstart
 * @create 2022-12-05 9:36
 */
//统一返回数据结构
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Results<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Results<T> success(T data) {
        return new Results<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Results<T> success(String message, T data) {
        return new Results<>(ResultEnum.SUCCESS.getCode(), message, data);
    }

    public static Results<?> failed(Integer code, String msg) {
        return new Results<>(ResultEnum.COMMON_FAILED.getCode(), ResultEnum.COMMON_FAILED.getMessage(), null);
    }

    public static Results<?> failed(String message) {
        return new Results<>(ResultEnum.COMMON_FAILED.getCode(), message, null);
    }

    public static Results<?> failed(IResult errorResult) {
        return new Results<>(errorResult.getCode(), errorResult.getMessage(), null);
    }

    public static <T> Results<T> instance(Integer code, String message, T data) {
        Results<T> result = new Results<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
