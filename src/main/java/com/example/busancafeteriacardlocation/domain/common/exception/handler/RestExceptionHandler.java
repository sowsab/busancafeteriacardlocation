package com.example.busancafeteriacardlocation.domain.common.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.busancafeteriacardlocation.domain.common.dto.ResponseDTO;
import com.example.busancafeteriacardlocation.domain.common.exception.BadRequestException;
import com.example.busancafeteriacardlocation.domain.common.exception.CustomNotFoundException;
import com.example.busancafeteriacardlocation.domain.common.exception.ForbbidenException;
import com.example.busancafeteriacardlocation.domain.common.exception.UnauthorizedException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(Exception exception) {
        exception.printStackTrace();
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(1)
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception) {
        exception.printStackTrace();
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(1)
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ResponseDTO<?>> handleUnauthorizedException(Exception exception) {
        exception.printStackTrace();
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(1)
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ForbbidenException.class)
    public ResponseEntity<ResponseDTO<?>> handleForbbidenException(Exception exception) {
        exception.printStackTrace();
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(1)
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<ResponseDTO<?>> handleCustomNotFoundException(Exception exception) {
        exception.printStackTrace();
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(1)
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.NOT_FOUND);
    }

}
