package com.feue.missyou.exception.http;

/**
 * @author Feue
 * @create 2021-07-16 11:14
 */
public class NotFoundException extends HttpException{
    public NotFoundException(int code) {
        this.HttpStatusCode = 404;
        this.code = code;
    }
}
