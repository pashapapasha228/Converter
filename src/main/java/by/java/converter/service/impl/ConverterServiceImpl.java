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
    public Converter convert(double amount1, String stringCode1, String stringCode2) {
        Converter converter = new Converter(stringCode1, amount1, stringCode2, 0);
        converter.getConvertation();
        return converter;
    }

    @Override
    public List<String> getAllCurrencies() {
        return Monetary.getCurrencies().stream().map(CurrencyUnit::getCurrencyCode).sorted().toList();
    }
}
