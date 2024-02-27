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
    public Converter convert(@RequestParam("val1") Double value1, @RequestParam("name1") String name1,
                             @RequestParam("name2") String name2) {
        return converterService.convert(value1, name1, name2);
    }

    @GetMapping("/showAll")
    public List<String> getAllCurrencies() {
        return converterService.getAllCurrencies();
    }
}
