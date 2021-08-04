package com.feue.missyou.exception.http;

/**
 * @author Feue
 * @create 2021-08-04 16:04
 */
public class UnAuthenticatedException extends HttpException{
    public UnAuthenticatedException(int code) {
        this.code = code;
        this.HttpStatusCode = 401;
    }
}
