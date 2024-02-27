package by.java.converter.service;

import by.java.converter.model.Converter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.money.CurrencyUnit;
import java.util.List;
import java.util.Set;

public interface ConverterService {
    Converter convert(double val1, String name1, String name2);

    List<String> getAllCurrencies();
}
