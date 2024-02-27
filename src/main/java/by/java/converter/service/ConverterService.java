package by.java.converter.service;

import by.java.converter.model.Converter;
import java.util.List;

public interface ConverterService {
    Converter convert(double val1, String name1, String name2);

    List<String> getAllCurrencies();
}
