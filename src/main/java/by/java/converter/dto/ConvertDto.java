package by.java.converter.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * DTO для сущности Convert.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ConvertDto {

  private Long id;

  private String currencyIn;
  private String currencyOut;
  private Double amountIn;
  private Double amountOut;
}
