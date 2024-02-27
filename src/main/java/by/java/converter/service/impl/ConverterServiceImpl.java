package by.java.converter.service.impl;

import by.java.converter.model.Converter;
import by.java.converter.service.ConverterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.util.List;

@Service
@AllArgsConstructor
public class ConverterServiceImpl implements ConverterService {
    @Override
    public Converter convert(double amount1, String string_code1, String string_code2) {
        Converter converter = new Converter(string_code1, amount1, string_code2, 0);
        converter.getConvertation();
        return converter;
    }

    @Override
    public List<String> getAllCurrencies() {
        return Monetary.getCurrencies().stream().map(CurrencyUnit::getCurrencyCode).sorted().toList();
    }
}
