package by.java.converter.dto;

import by.java.converter.model.Convert;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ConvertHistoryDTO {
    private Long id;
    private LocalDateTime localDateTime;
    private Set<Convert> converts;
}
