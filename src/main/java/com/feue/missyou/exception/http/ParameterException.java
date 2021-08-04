package com.feue.missyou.exception.http;

/**
 * @author Feue
 * @create 2021-07-16 11:16
 */
public class ParameterException extends HttpException{
    public ParameterException(int code) {
        this.HttpStatusCode = 400;
        this.code = code;
    }
}
