package by.java.converter.service;

import by.java.converter.dto.ConvertDTO;
import by.java.converter.model.Convert;
import by.java.converter.repository.ConvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvertService {

    private final ConvertRepository convertRepository;

    @Autowired
    public ConvertService(ConvertRepository convertRepository) {
        this.convertRepository = convertRepository;
    }

    public List<ConvertDTO> getAll() {
        List<Convert> list = convertRepository.findAll();

        return list
                .stream()
                .map(convert -> new ConvertDTO(
                                convert.getId(),
                                convert.getCurrencyIn(),
                                convert.getCurrencyOut(),
                                convert.getAmountIn(),
                                convert.getAmountOut()
                        )
                ).toList();
    }

    public ConvertDTO getById(Long id) {
        Convert convert = convertRepository.findById(id).orElseThrow(() -> new RuntimeException("Convert not found by getting"));

        return new ConvertDTO(
                convert.getId(),
                convert.getCurrencyIn(),
                convert.getCurrencyOut(),
                convert.getAmountIn(),
                convert.getAmountOut()
        );
    }

    public void create(ConvertDTO convertDto) {
        Convert convert = new Convert();

        convert.setAmountIn(convertDto.getAmountIn());
        convert.setAmountOut(convertDto.getAmountOut());
        convert.setCurrencyIn(convertDto.getCurrencyIn());
        convert.setCurrencyOut(convertDto.getCurrencyOut());

        convertRepository.save(convert);
    }

    public void delete(Long id) {
        Convert convert = convertRepository.findById(id).orElseThrow(() -> new RuntimeException("Convert not found by deleting"));

        convertRepository.delete(convert);
    }

    public void update(Long id, ConvertDTO convertDTO) {
        Convert convert = convertRepository.findById(id).orElseThrow(() -> new RuntimeException("Convert not found by updating"));

        convert.setAmountIn(convertDTO.getAmountIn());
        convert.setAmountOut(convertDTO.getAmountOut());
        convert.setCurrencyIn(convertDTO.getCurrencyIn());
        convert.setCurrencyOut(convertDTO.getCurrencyOut());

        convertRepository.save(convert);
    }
}
