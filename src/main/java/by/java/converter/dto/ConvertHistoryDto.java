package by.java.converter.dto;

import by.java.converter.model.Convert;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO для сущности ConvertHistory.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ConvertHistoryDto {
  private Long id;
  private LocalDateTime localDateTime;
  private Set<Convert> converts;
}
