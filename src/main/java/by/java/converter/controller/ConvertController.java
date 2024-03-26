package by.java.converter.controller;

import by.java.converter.dto.ConvertDto;
import by.java.converter.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/convert")
public class ConvertController {

    private final ConvertService convertService;

    @Autowired
    public ConvertController(ConvertService convertService) {
        this.convertService = convertService;
    }

    @GetMapping
    public ResponseEntity<List<ConvertDto>> getAll() {
        return new ResponseEntity<>(convertService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConvertDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(convertService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ConvertDto convertDto) {
        convertService.create(convertDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        convertService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
