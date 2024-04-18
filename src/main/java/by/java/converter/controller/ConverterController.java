package by.java.converter.controller;

import by.java.converter.dto.RequestDto;
import by.java.converter.dto.ResponseDto;
import by.java.converter.service.ConverterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Основной контроллер для работы с приложением.
 */
@RestController
@RequestMapping("/api/v1/converter")
@AllArgsConstructor
public class ConverterController {
  private final ConverterService converterService;

  /**
   * Получение всех конвертаций.
   */
  @GetMapping("/getAll")
  public ResponseEntity<ResponseDto> getAll() {
    ResponseDto responseDto = converterService.getAll();

    return new ResponseEntity<>(responseDto, HttpStatus.OK);
  }

  /**
   * Конвертация списка валют, занесение в базу данных
   * и возвращение результата конвертации.
   */
  @PostMapping("/convert")
  public ResponseEntity<ResponseDto> convert(@RequestBody RequestDto requestDto) {
    ResponseDto responseDto = converterService.convert(requestDto);

    return new ResponseEntity<>(responseDto, HttpStatus.OK);
  }
}
