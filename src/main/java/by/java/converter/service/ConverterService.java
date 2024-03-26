package by.java.converter.service;

import by.java.converter.dto.ConvertDTO;
import by.java.converter.dto.RequestDTO;
import by.java.converter.dto.ResponseDTO;
import by.java.converter.model.Convert;
import by.java.converter.model.ConvertHistory;
import by.java.converter.repository.ConvertHistoryRepository;
import by.java.converter.repository.ConvertRepository;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Service;

import javax.money.convert.MonetaryConversions;
import java.util.*;

@Service
public class ConverterService {

    private final ConvertRepository convertRepository; // service
    private final ConvertHistoryRepository convertHistoryRepository;  // service

    public ConverterService(ConvertRepository convertRepository,
                            ConvertHistoryRepository convertHistoryRepository) {
        this.convertRepository = convertRepository;
        this.convertHistoryRepository = convertHistoryRepository;
    }

    public ResponseDTO convert(RequestDTO requestDto) {

        // Создаем множество конвертаций
        Set<Convert> convertSet = new HashSet<>();

        // Создаем входную валюту
        Money moneyIn = Money.of(requestDto.getAmountIn(), requestDto.getCurrencyIn());

        requestDto
                .getCurrenciesOut()
                .forEach( // Для каждого кода выходной валюты
                        c -> {
                            Money moneyOut = moneyIn // создаем выходную валюту
                                    .with(
                                            MonetaryConversions // Конвертируем
                                                    .getExchangeRateProvider()
                                                    .getCurrencyConversion(c)
                                    );

                            // Создаем конвертацию
                            Convert convert = new Convert();

                            convert.setCurrencyOut(moneyOut.getCurrency().getCurrencyCode());
                            convert.setCurrencyIn(moneyIn.getCurrency().getCurrencyCode());
                            convert.setAmountIn(moneyIn.getNumber().doubleValue());
                            convert.setAmountOut(moneyOut.getNumber().doubleValue());

                            convertSet.add(convert); // добавляем в множество

                            convertRepository.save(convert); // сохраняем
                        }
                );

        ConvertHistory convertHistory = new ConvertHistory(); // создаем информацию о запросе

        convertHistory.setConverts(convertSet); // устанавливаем туда множество конвертаций

        convertHistoryRepository.save(convertHistory); // сохраняем

        List<ConvertDTO> converts = convertSet.stream() // Преобразуем конвертации в ДТО
                .map(convert -> new ConvertDTO(
                                convert.getId(),
                                convert.getCurrencyIn(),
                                convert.getCurrencyOut(),
                                convert.getAmountIn(),
                                convert.getAmountOut()
                        )
                ).toList();

        return new ResponseDTO(converts);
    }

    public ResponseDTO getAll() {
        List<ConvertDTO> converts = convertRepository.findAll().stream() // Преобразуем конвертации в ДТО
                .map(convert -> new ConvertDTO(
                                convert.getId(),
                                convert.getCurrencyIn(),
                                convert.getCurrencyOut(),
                                convert.getAmountIn(),
                                convert.getAmountOut()
                        )
                ).toList();

        return new ResponseDTO(converts);
    }
}
