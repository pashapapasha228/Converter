package by.java.converter.exceptions;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс ошибок.
 */
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
  private LocalDateTime dateTime;
  private Integer status;
  private String message;
}
