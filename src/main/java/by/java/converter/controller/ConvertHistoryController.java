package by.java.converter.controller;

import by.java.converter.dto.ConvertHistoryDTO;
import by.java.converter.service.ConvertHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/v1/history")
public class ConvertHistoryController {
    private final ConvertHistoryService convertHistoryService;

    @Autowired
    public ConvertHistoryController(ConvertHistoryService convertHistoryService) {
        this.convertHistoryService = convertHistoryService;
    }

    @GetMapping
    public ResponseEntity<List<ConvertHistoryDTO>> getAll() {
        return new ResponseEntity<>(convertHistoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConvertHistoryDTO> getById(@PathVariable Long id) {
        return new ResponseEntity<>(convertHistoryService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ConvertHistoryDTO> create(@RequestBody ConvertHistoryDTO convertHistoryDTO) {
        convertHistoryService.create(convertHistoryDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        convertHistoryService.delete(id);
    }
}
