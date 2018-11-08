package com.evshang.response;

import lombok.Data;

@Data
public class FallbackResponse {

    private int httpStatus;

    private int errorCode;

    private Object respone;



}
