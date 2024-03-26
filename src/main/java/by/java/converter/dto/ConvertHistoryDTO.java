package by.java.converter.dto;

import by.java.converter.model.Convert;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConvertHistoryDTO {
    private Long id;
    private LocalDateTime localDateTime;
    private Set<Convert> converts;
}
