package by.java.converter.controller;

import by.java.converter.dto.RequestDTO;
import by.java.converter.dto.ResponseDTO;
import by.java.converter.service.ConverterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/converter")
@AllArgsConstructor
public class ConverterController {

    private final ConverterService converterService;

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAll() {
        ResponseDTO responseDto = converterService.getAll();

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping("/convert")
    public ResponseEntity<ResponseDTO> convert(@RequestBody RequestDTO requestDto) {
        ResponseDTO responseDto = converterService.convert(requestDto);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
