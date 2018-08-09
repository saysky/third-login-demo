package com.liuyanzhao.demo.util;

import lombok.Data;

/**
 * @author 言曌
 * @date 2018/8/8 下午11:45
 */

@Data
public class Response<T> {

    private Integer code;

    private String message;

    private T data;

    public Response(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
