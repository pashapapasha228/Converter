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
    public Converter convert(@RequestParam("amount1") Double amount1, @RequestParam("stringCode1") String stringCode1,
                             @RequestParam("stringCode2") String stringCode2) {
        return converterService.convert(amount1, stringCode1, stringCode2);
    }

    @GetMapping("/showAll")
    public List<String> getAllCurrencies() {
        return converterService.getAllCurrencies();
    }
}
