package com.jasonlee213.common.dtos;

import java.util.ArrayList;

public class CommonListDataResponse<T> extends CommonResponse{
    public CommonListDataResponse(int status, String message, ArrayList<T> data){
        super(status, message);
        this.data = data;
    }
    private ArrayList<T> data;
}
