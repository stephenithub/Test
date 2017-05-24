package com.stephen.test.base;


/**
 * Created by Stephen on 2017/5/12 14:56
 * Email: 895745843@qq.com
 */

public class HttpResponse<T>{
    private boolean status;
    private String Message;
    private String errorInfo;
    private T data;

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return Message;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public T getData() {
        return data;
    }
}
