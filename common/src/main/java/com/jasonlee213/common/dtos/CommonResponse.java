package com.jasonlee213.common.dtos;

public class CommonResponse {
    public CommonResponse(int status, String message){
        this.status = status;
        this.message = message;
    }

    private int status;
    private String message;
}
