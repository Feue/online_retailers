package com.feue.missyou.exception.http;

/**
 * @author Feue
 * @create 2021-07-16 11:16
 */
public class ForbiddenException extends HttpException{
    public ForbiddenException(int code) {
        this.HttpStatusCode = 403;
        this.code = code;
    }
}
