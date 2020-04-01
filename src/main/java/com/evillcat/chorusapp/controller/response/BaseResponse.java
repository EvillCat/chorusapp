package com.evillcat.chorusapp.controller.response;

import lombok.Data;

@Data
public class BaseResponse<T> {

    private T data;
    private String message;

}
