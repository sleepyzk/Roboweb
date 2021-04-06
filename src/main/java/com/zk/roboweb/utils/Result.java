package com.zk.roboweb.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 操作成功，无返回数据
     *
     * @return
     */
    public static Result<Object> success() {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), "");
    }


    /**
     * 操作成功，有返回数据
     * @param object
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T object) {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), object);
    }

    /**
     * 操作失败，无返回数据
     * @return
     */
    public static Result<Object> fail(){
        return new Result<>(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMsg(),"");
    }
}
