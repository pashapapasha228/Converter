package by.java.converter.service;

import by.java.converter.dto.ConvertDto;
import by.java.converter.model.Convert;
import by.java.converter.repository.ConvertRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис для сущности Convert.
 */
@Service
public class ConvertService {

  private final ConvertRepository convertRepository;

  @Autowired
  public ConvertService(ConvertRepository convertRepository) {
    this.convertRepository = convertRepository;
  }

  /**
   * Получение всех Convert из базы данных.
   */
  public List<ConvertDto> getAll() {
    List<Convert> list = convertRepository.findAll();

    return list
      .stream()
      .map(convert -> new ConvertDto(
        convert.getId(),
        convert.getCurrencyIn(),
        convert.getCurrencyOut(),
        convert.getAmountIn(),
        convert.getAmountOut()
        )
      ).toList();
  }

  /**
   * Получение Convert по id из базы данных.
   */
  public ConvertDto getById(Long id) {
    Convert convert = convertRepository.findById(id).orElseThrow(
        () -> new RuntimeException("Convert not found by getting")
    );

    return new ConvertDto(
      convert.getId(),
      convert.getCurrencyIn(),
      convert.getCurrencyOut(),
      convert.getAmountIn(),
      convert.getAmountOut()
    );
  }

  /**
   * Получение всех Converts c полями равными
   * currencyIn и currencyOut из базы данных.
   */
  public List<ConvertDto> getByCurrencies(String currencyIn, String currencyOut) {
    List<Convert> list = convertRepository.getConvertsByCurrencies(currencyIn, currencyOut);

    return list
                .stream()
                .map(convert -> new ConvertDto(
                                convert.getId(),
                                convert.getCurrencyIn(),
                                convert.getCurrencyOut(),
                                convert.getAmountIn(),
                                convert.getAmountOut()
                        )
                ).toList();
  }

  /**
   * Создание Convert в базу данных.
   */
  public void create(ConvertDto convertDto) {
    Convert convert = new Convert();

    convert.setAmountIn(convertDto.getAmountIn());
    convert.setAmountOut(convertDto.getAmountOut());
    convert.setCurrencyIn(convertDto.getCurrencyIn());
    convert.setCurrencyOut(convertDto.getCurrencyOut());

    convertRepository.save(convert);
  }

  /**
   * Удаление Convert с id из базы данных.
   */
  public void delete(Long id) {
    Convert convert = convertRepository.findById(id).orElseThrow(
        () -> new RuntimeException("Convert not found by deleting")
    );

    convertRepository.delete(convert);
  }

  /**
   * Обновление Convert с id в базу данных.
   */
  public void update(Long id, ConvertDto convertDto) {
    Convert convert = convertRepository.findById(id).orElseThrow(
        () -> new RuntimeException("Convert not found by updating")
    );

    convert.setAmountIn(convertDto.getAmountIn());
    convert.setAmountOut(convertDto.getAmountOut());
    convert.setCurrencyIn(convertDto.getCurrencyIn());
    convert.setCurrencyOut(convertDto.getCurrencyOut());

    convertRepository.save(convert);
  }
}
