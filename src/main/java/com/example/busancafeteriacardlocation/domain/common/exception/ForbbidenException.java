package com.example.busancafeteriacardlocation.domain.common.exception;

public class ForbbidenException extends RuntimeException {
    
    public ForbbidenException(String message) {
        super(message);
    }

    public ForbbidenException() {
        super("권한이 없습니다");
    }

}
