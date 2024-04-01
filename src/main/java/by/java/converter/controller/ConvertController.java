package by.java.converter.controller;

import by.java.converter.dto.ConvertDTO;
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

    @GetMapping("/getAll")
    public ResponseEntity<List<ConvertDTO>> getAll() {
        return new ResponseEntity<>(convertService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ConvertDTO> getById(@PathVariable Long id) {
        return new ResponseEntity<>(convertService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ConvertDTO> create(@RequestBody ConvertDTO convertDto) {
        convertService.create(convertDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody ConvertDTO convertDTO) {
        convertService.update(id, convertDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        convertService.delete(id);
    }

}
