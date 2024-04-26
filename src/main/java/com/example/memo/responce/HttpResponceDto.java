package com.example.memo.responce;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpResponceDto {

    private HttpStatus httpStatus;

    private String message;

    private Object responceData;
}
