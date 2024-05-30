package by.java.converter.controller;

import by.java.converter.dto.ConvertDto;
import by.java.converter.service.ConvertService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для сущности Convert.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/convert")
public class ConvertController {
  private final ConvertService convertService;

  @Autowired
  public ConvertController(ConvertService convertService) {
    this.convertService = convertService;
  }

  @GetMapping("/getAll")
  public ResponseEntity<List<ConvertDto>> getAll() {
    return new ResponseEntity<>(convertService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<ConvertDto> getById(@PathVariable Long id) {
    return new ResponseEntity<>(convertService.getById(id), HttpStatus.OK);
  }

  @GetMapping("/getByCur")
  public ResponseEntity<List<ConvertDto>> getByCurrencies(@RequestParam String currencyIn,
                                                          @RequestParam String currencyOut) {
    return new ResponseEntity<>(convertService.getByCurrencies(currencyIn, currencyOut),
        HttpStatus.OK);
  }

  @PostMapping("/create")
  public ResponseEntity<ConvertDto> create(@RequestBody ConvertDto convertDto) {
    convertService.create(convertDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping("/update/{id}")
  public void update(@PathVariable Long id, @RequestBody ConvertDto convertDto) {
    convertService.update(id, convertDto);
  }

  @DeleteMapping("/delete/{id}")
  public void delete(@PathVariable Long id) {
    convertService.delete(id);
  }

}
