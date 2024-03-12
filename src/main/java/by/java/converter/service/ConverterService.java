package by.java.converter.service;

import by.java.converter.model.Converter;
import java.util.List;

public interface ConverterService {
    Converter convert(double amountIn, String currencyIn, String currencyOut);

    List<String> getAllCurrencies();
}
