package by.java.converter.service;

import by.java.converter.dto.ConvertHistoryDTO;

import by.java.converter.model.ConvertHistory;
import by.java.converter.repository.ConvertHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvertHistoryService {

    private final ConvertHistoryRepository convertHistoryRepository;

    @Autowired
    public ConvertHistoryService(ConvertHistoryRepository convertHistoryRepository) {
        this.convertHistoryRepository = convertHistoryRepository;
    }

    public List<ConvertHistoryDTO> getAll() {
        List<ConvertHistory> list = convertHistoryRepository.findAll();

        return list
                .stream()
                .map(convertHistory -> new ConvertHistoryDTO(
                                convertHistory.getId(),
                                convertHistory.getLocalDateTime(),
                                convertHistory.getConverts()
                        )
                ).toList();
    }

    public ConvertHistoryDTO getById(Long id) {
        ConvertHistory convertHistory = convertHistoryRepository.findById(id).orElseThrow(() -> new RuntimeException("ConvertHistory not found"));

        return new ConvertHistoryDTO(
                convertHistory.getId(),
                convertHistory.getLocalDateTime(),
                convertHistory.getConverts()
        );
    }

    public void create(ConvertHistoryDTO convertHistoryDto) {
        ConvertHistory convertHistory = new ConvertHistory();

        convertHistory.setLocalDateTime(convertHistoryDto.getLocalDateTime());
        convertHistory.setConverts(convertHistoryDto.getConverts());

        convertHistoryRepository.save(convertHistory);
    }

    public void delete(Long id) {
        ConvertHistory convertHistory = convertHistoryRepository.findById(id).orElseThrow(() -> new RuntimeException("ConvertHistory not found"));

        convertHistoryRepository.delete(convertHistory);
    }
}
