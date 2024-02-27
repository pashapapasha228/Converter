package by.java.converter.service;

import by.java.converter.model.Converter;
import java.util.List;

public interface ConverterService {
    Converter convert(double amount1, String stringCode1, String stringCode2);

    List<String> getAllCurrencies();
}
