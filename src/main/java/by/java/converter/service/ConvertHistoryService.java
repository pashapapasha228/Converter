package by.java.converter.service;

import by.java.converter.cache.ConvertHistoryCache;
import by.java.converter.dto.ConvertHistoryDto;
import by.java.converter.model.ConvertHistory;
import by.java.converter.repository.ConvertHistoryRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Ковертер для ConvertHistoryService.
 */
@Service
public class ConvertHistoryService {

  private final ConvertHistoryRepository convertHistoryRepository;
  private final ConvertHistoryCache convertHistoryCache;

  @Autowired
  public ConvertHistoryService(ConvertHistoryRepository convertHistoryRepository,
                               ConvertHistoryCache convertHistoryCache) {
    this.convertHistoryCache = convertHistoryCache;
    this.convertHistoryRepository = convertHistoryRepository;
  }

  /**
   * Получение всех ConvertHistory из базы данных.
   */
  public List<ConvertHistoryDto> getAll() {
    List<ConvertHistory> list = convertHistoryRepository.findAll();

    return list
      .stream()
      .map(convertHistory -> new ConvertHistoryDto(
        convertHistory.getId(),
        convertHistory.getLocalDateTime(),
        convertHistory.getConverts()
      )
    ).toList();
  }

  /**
   * Получение ConvertHistory из базы данных по id.
   */
  public ConvertHistoryDto getById(Long id) {
    ConvertHistory convertHistory = convertHistoryCache.get(id);

    if (convertHistory == null) {
      convertHistory = convertHistoryRepository.findById(id).orElseThrow(
        () -> new NoSuchElementException("ConvertHistory not found by getting")
      );

      convertHistoryCache.put(id, convertHistory);
    }

    return new ConvertHistoryDto(
      convertHistory.getId(),
      convertHistory.getLocalDateTime(),
      convertHistory.getConverts()
    );
  }

  /**
   * Создание ConvertHistory в базе данных.
   */
  public void create(ConvertHistoryDto convertHistoryDto) {
    ConvertHistory convertHistory = new ConvertHistory();

    convertHistory.setLocalDateTime(convertHistoryDto.getLocalDateTime());
    convertHistory.setConverts(convertHistoryDto.getConverts());

    convertHistoryRepository.save(convertHistory);

    convertHistoryCache.put(convertHistory.getId(), convertHistory);
  }

  /**
   * Обновление ConvertHistory в базе данных по id.
   */
  public void update(Long id, ConvertHistoryDto convertHistoryDtoIn) {
    ConvertHistory convertHistory = convertHistoryRepository.findById(id).orElseThrow(
        () -> new NoSuchElementException("ConvertHistory not found by updating")
    );

    convertHistory.setLocalDateTime(convertHistoryDtoIn.getLocalDateTime());
    convertHistory.setConverts(convertHistoryDtoIn.getConverts());

    convertHistoryRepository.save(convertHistory);

    //convertHistoryCache.remove(id);
    convertHistoryCache.put(id, convertHistory);
  }

  /**
   * Удаление ConvertHistory из базы данных по id.
   */
  public void delete(Long id) {
    ConvertHistory convertHistory = convertHistoryRepository.findById(id).orElseThrow(
        () -> new NoSuchElementException("ConvertHistory not found by deleting")
    );

    convertHistoryRepository.delete(convertHistory);
    convertHistoryCache.remove(id);
  }
}
