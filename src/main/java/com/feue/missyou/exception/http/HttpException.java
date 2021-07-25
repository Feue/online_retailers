package com.feue.missyou.exception.http;

/**
 * @author Feue
 * @create 2021-07-16 11:12
 */
public class HttpException extends RuntimeException{
    protected Integer code;
    protected Integer HttpStatusCode = 500;

    public Integer getCode() {
        return code;
    }

    public Integer getHttpStatusCode() {
        return HttpStatusCode;
    }
}
