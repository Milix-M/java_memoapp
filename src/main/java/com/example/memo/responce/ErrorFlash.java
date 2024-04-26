package com.example.memo.responce;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorFlash {

    private String errorType;

    private String errorMsg;

    public ErrorFlash() {
    }

    public ErrorFlash(String errorType, String errorMsg) {
        this.errorType = errorType;
        this.errorMsg = errorMsg;
    }
}
