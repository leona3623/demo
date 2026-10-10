package com.example.demo.exception;

import com.example.demo.common.Result;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;

//这个类专门负责处理 Controller 层出现的异常。
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result handleUserNotFoundxception(UserNotFoundException e){
        return Result.error(404,e.getMessage());
    }
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleOtherException(RuntimeException e){
        return Result.error(500, "服务器内部错误");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        HashMap<String,String> map = new HashMap<>();
        for (FieldError error : errors) {
            map.put(error.getField(),error.getDefaultMessage());
        }
        return Result.error(400,"参数校验异常",map);
    }
}
