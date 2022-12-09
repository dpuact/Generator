package com.bijw.generator.common.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author shkstart
 * @create 2022-12-08 9:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Result implements Serializable {

    private Boolean success;

    private Integer code;

    private String message;

    private Object data;


    public static Result success(){
        return new Result(ResultEnum.SUCCESS.getSuccess(),ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),null);
    }

    public static Result success(Object data){
        return new Result(ResultEnum.SUCCESS.getSuccess(),ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),data);
    }

    public static Result success(String message, Object data){
        return new Result(ResultEnum.SUCCESS.getSuccess(),ResultEnum.SUCCESS.getCode(),message,data);
    }

    public static Result failed(){
        return new Result(ResultEnum.FAILED.getSuccess(), ResultEnum.FAILED.getCode(),ResultEnum.FAILED.getMsg(),null);
    }

    public static Result failed(String message){
        return new Result(ResultEnum.FAILED.getSuccess(), ResultEnum.FAILED.getCode(),message,null);
    }

    /*参数异常*/
    public static Result param_error(){
        return new Result(ResultEnum.PARAM_ERROR.getSuccess(), ResultEnum.PARAM_ERROR.getCode(), ResultEnum.PARAM_ERROR.getMsg(),null);
    }

    public static Result param_error(String message){
        return new Result(ResultEnum.PARAM_ERROR.getSuccess(), ResultEnum.PARAM_ERROR.getCode(),message,null);
    }

}
