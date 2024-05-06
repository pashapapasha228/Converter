package by.java.converter.exceptions;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Обработчик 400, 404, 500 ошибок.
 */
@RestControllerAdvice
public class ExceptionsHandler {
  /**
   * Обработка 400 ошибки.
   */
  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<Object> badRequestException(Exception ex) {

    return new ResponseEntity<>(new ErrorResponse(LocalDateTime.now(),
        400, ex.getMessage()),
        HttpStatus.BAD_REQUEST);
  }

  /**
   * Обработка 404 ошибки.
  */
  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<Object> notFoundException(Exception ex) {

    return new ResponseEntity<>(new ErrorResponse(LocalDateTime.now(), 404, ex.getMessage()),
                HttpStatus.NOT_FOUND);
  }

  /**
   * Обработка 500 ошибки.
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> internalServerErrorException(Exception ex) {

    return new ResponseEntity<>(new ErrorResponse(LocalDateTime.now(), 500, ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
