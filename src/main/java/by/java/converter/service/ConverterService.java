package by.java.converter.service;

import by.java.converter.model.Converter;
import java.util.List;

public interface ConverterService {
    Converter convert(double amount1, String string_code1, String string_code2);

    List<String> getAllCurrencies();
}
