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
    public Converter convert(double amountIn, String currencyIn, String currencyOut) {
        Converter converter = new Converter(currencyIn, amountIn, currencyOut, 0);
        converter.getConversion();
        return converter;
    }

    @Override
    public List<String> getAllCurrencies() {
        return Monetary.getCurrencies().stream().map(CurrencyUnit::getCurrencyCode).sorted().toList();
    }
}
