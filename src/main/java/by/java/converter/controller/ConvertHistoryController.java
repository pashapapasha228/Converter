package by.java.converter.controller;

import by.java.converter.dto.ConvertHistoryDto;
import by.java.converter.service.ConvertHistoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер сущности ConvertHistory.
 */
@RestController()
@RequestMapping("api/v1/history")
public class ConvertHistoryController {
  private final ConvertHistoryService convertHistoryService;

  @Autowired
  public ConvertHistoryController(ConvertHistoryService convertHistoryService) {
    this.convertHistoryService = convertHistoryService;
  }

  @GetMapping("/getAll")
  public ResponseEntity<List<ConvertHistoryDto>> getAll() {
    return new ResponseEntity<>(convertHistoryService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<ConvertHistoryDto> getById(@PathVariable Long id) {
    return new ResponseEntity<>(convertHistoryService.getById(id), HttpStatus.OK);
  }

  /**
   * Внесение нового объекта в базу данных.
   */
  @PostMapping("/create")
  public ResponseEntity<ConvertHistoryDto> create(@RequestBody ConvertHistoryDto
                                                        convertHistoryDto) {
    convertHistoryService.create(convertHistoryDto);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping("/update/{id}")
  public void update(@PathVariable Long id, @RequestBody ConvertHistoryDto convertHistoryDtoIn) {
    convertHistoryService.update(id, convertHistoryDtoIn);
  }

  @DeleteMapping("/delete/{id}")
  public void delete(@PathVariable Long id) {
    convertHistoryService.delete(id);
  }
}
