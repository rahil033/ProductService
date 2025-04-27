package com.rahil.productservice.controlleradvice;

import com.rahil.productservice.dtos.ExceptionDto;
import com.rahil.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException() {
        ResponseEntity<String> response = new ResponseEntity<>(
                "Arithmetic Exception has happenend",
                HttpStatus.NOT_FOUND
        );
        return response;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleArrayIndexOutOfBoundsException() {
        ResponseEntity<String> response = new ResponseEntity<>(
                "ArrayIndexOutOfBoundsException has happenend",
                HttpStatus.NOT_FOUND
        );
        return response;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException() {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Product ID Not Found");
        exceptionDto.setSolution("Please try with valid product ID");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.NOT_FOUND
        );
        return response;
    }


}
