package com.jasonlee213.common.dtos;

public class CommonDataResponse<T> extends CommonResponse{
    public CommonDataResponse(int status, String message, T data){
        super(status, message);
        this.data = data;
    }
    private T data;
}
