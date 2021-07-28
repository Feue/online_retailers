package com.feue.missyou.exception.http;

/**
 * @author Feue
 * @create 2021-07-26 11:10
 */
public class ServerErrorException extends HttpException{
    public ServerErrorException(int code) {
        this.code = code;
        this.HttpStatusCode = 500;
    }
}
