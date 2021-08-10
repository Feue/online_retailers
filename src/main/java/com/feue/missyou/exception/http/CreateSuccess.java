package com.feue.missyou.exception.http;

/**
 * @author Feue
 * @create 2021-08-09 15:06
 */
public class CreateSuccess extends HttpException{
    public CreateSuccess(int code) {
        this.HttpStatusCode = 201;
        this.code = code;
    }
}
