package by.java.converter.controller;

import by.java.converter.dto.RequestDto;
import by.java.converter.dto.ResponseDto;
import by.java.converter.service.ConvertService;
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

    //    @GetMapping("/convert")
//    public Converter convert(@RequestParam("amountIn") Double amountIn, @RequestParam("currencyIn") String currencyIn,
//                             @RequestParam("currencyOut") String currencyOut) {
//        return converterService.convert(amountIn, currencyIn, currencyOut);
//    }

//    @PostMapping("/convert")
//    public Converter convert(
//            @RequestBody AmountDTO amountDTO,
//            @Request
//            ) {
//        return converterService.convert(amountIn, currencyIn, currencyOut);
//    }
//
//    @GetMapping("/showAll")
//    public List<String> getAllCurrencies() {
//        return converterService.getAllCurrencies();
//    }
//
//    // GET
//    @GetMapping("/all")
//    public ResponseEntity<?> getAll() {
//        return new ResponseEntity<>(converterService.getAll(), HttpStatus.OK);
//    }

    @PostMapping("/convert")
    public ResponseEntity<?> convert(@RequestBody RequestDto requestDto) {
        ResponseDto responseDto = converterService.convert(requestDto);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
