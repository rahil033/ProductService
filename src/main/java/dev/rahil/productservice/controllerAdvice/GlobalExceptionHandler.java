package dev.rahil.productservice.controllerAdvice;

import dev.rahil.productservice.dtos.ExceptionDto;
import dev.rahil.productservice.exceptions.ProductNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException() {
        ResponseEntity<String> response = new ResponseEntity<>(
                "Something went wrong. Coming from controller Advice",
                HttpStatus.NOT_FOUND
        );
        return response;
    }
    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException() {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Product not found");
        exceptionDto.setDetails("Please try with Valid ID");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return response;
    }


}
