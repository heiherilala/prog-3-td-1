package app.prog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Date;


@ControllerAdvice
public class FormExeptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExeptionResponse> NotFoundExceptionHandler(NotFoundException exeption) {
        return new ResponseEntity<>(new ExeptionResponse(exeption.getMessage(), "404"), HttpStatus.NOT_FOUND);
    }


}
