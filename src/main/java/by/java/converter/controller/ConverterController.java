package by.java.converter.controller;

import by.java.converter.model.Converter;
import by.java.converter.service.impl.ConverterServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/converter")
@AllArgsConstructor
public class ConverterController {

    private final ConverterServiceImpl converterService;

    @GetMapping("/convert")
    public Converter convert(@RequestParam("amountIn") Double amountIn, @RequestParam("currencyIn") String currencyIn,
                             @RequestParam("currencyOut") String currencyOut) {
        return converterService.convert(amountIn, currencyIn, currencyOut);
    }

    @GetMapping("/showAll")
    public List<String> getAllCurrencies() {
        return converterService.getAllCurrencies();
    }
}
