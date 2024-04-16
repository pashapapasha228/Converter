package by.java.converter.exceptions;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> badRequestException(Exception ex) {

        return new ResponseEntity<>(new ErrorResponse(LocalDateTime.now(), 400, ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> notFoundException(Exception ex) {

        return new ResponseEntity<>(new ErrorResponse(LocalDateTime.now(), 404, ex.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> internalServerErrorException(Exception ex) {

        return new ResponseEntity<>(new ErrorResponse(LocalDateTime.now(), 500, ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
