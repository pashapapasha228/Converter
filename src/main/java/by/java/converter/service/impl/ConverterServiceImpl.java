package by.java.converter.service.impl;

import by.java.converter.model.Converter;
import by.java.converter.service.ConverterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ConverterServiceImpl implements ConverterService {
    @Override
    public Converter convert(double val1, String name1, String name2) {
        Converter converter = new Converter(name1, val1, name2, 0);
        converter.getConvertation();
        return converter;
    }

    @Override
    public List<String> getAllCurrencies() {
        return Monetary.getCurrencies().stream().map(CurrencyUnit::getCurrencyCode).sorted().toList();
    }
}
