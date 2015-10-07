package com.mybatis.exception;
/**
 * Created by pl on 2015/9/27.
 */
//自定义异常
public class CustomException extends Exception{
    public CustomException(String message){
        super(message);
        this.message = message;
    }

    //异常信息
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
