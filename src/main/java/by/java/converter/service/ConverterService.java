package by.java.converter.service;

import by.java.converter.cache.ConvertHistoryCache;
import by.java.converter.dto.ConvertDto;
import by.java.converter.dto.RequestDto;
import by.java.converter.dto.ResponseDto;
import by.java.converter.model.Convert;
import by.java.converter.model.ConvertHistory;
import by.java.converter.repository.ConvertHistoryRepository;
import by.java.converter.repository.ConvertRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.convert.MonetaryConversions;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Service;

/**
 * Основной сервис приложения.
 */
@Service
public class ConverterService {

  private final ConvertRepository convertRepository; // service
  private final ConvertHistoryRepository convertHistoryRepository;  // service

  private final ConvertHistoryCache convertHistoryCache;

  /**
   * Конструктор для внедрения зависимостей.
   */
  public ConverterService(ConvertRepository convertRepository,
                          ConvertHistoryRepository convertHistoryRepository,
                          ConvertHistoryCache convertHistoryCache) {
    this.convertRepository = convertRepository;
    this.convertHistoryRepository = convertHistoryRepository;
    this.convertHistoryCache = convertHistoryCache;
  }

  /**
   * Метод конвертации входных валют.
   */
  public ResponseDto convert(RequestDto requestDto) {

    // Создаем множество конвертаций
    Set<Convert> convertSet = new HashSet<>();

    // Создаем входную валюту
    Money moneyIn = Money.of(requestDto.getAmountIn(), requestDto.getCurrencyIn());

    requestDto
        .getCurrenciesOut()
        .forEach(
          // Для каждого кода выходной валюты
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
          }
        );

    ConvertHistory convertHistory = new ConvertHistory(); // создаем информацию о запросе

    convertHistory.setConverts(convertSet); // устанавливаем туда множество конвертаций

    convertHistoryRepository.save(convertHistory); // сохраняем
    convertSet.forEach(
        convert -> {
          convert.setConvertHistory(convertHistory);
          convertRepository.save(convert);
        }
    );

    convertHistoryCache.put(convertHistory.getId(), convertHistory);

    List<ConvertDto> converts = convertSet.stream() // Преобразуем конвертации в ДТО
        .map(convert -> new ConvertDto(
          convert.getId(),
          convert.getCurrencyIn(),
          convert.getCurrencyOut(),
          convert.getAmountIn(),
          convert.getAmountOut()
        )
    ).toList();

    return new ResponseDto(converts);
  }

  /**
   * Получение всех преобразований валют в базе данных.
   */
  public ResponseDto getAll() {
    // Преобразуем конвертации в ДТО
    List<ConvertDto> converts = convertRepository.findAll().stream()
        .map(convert -> new ConvertDto(
          convert.getId(),
          convert.getCurrencyIn(),
          convert.getCurrencyOut(),
          convert.getAmountIn(),
          convert.getAmountOut()
        )
      ).toList();

    return new ResponseDto(converts);
  }

  public List<String> getAllPossibleCodes() {
    return Monetary.getCurrencies().stream()
        .map(CurrencyUnit::getCurrencyCode).sorted().toList();
  }
}
