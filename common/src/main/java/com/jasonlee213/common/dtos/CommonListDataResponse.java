package com.jasonlee213.common.dtos;

import java.util.List;

public class CommonListDataResponse<T> extends CommonResponse{
    public CommonListDataResponse(int status, String message, List<T> data){
        super(status, message);
        this.data = data;
    }
    private List<T> data;
}
