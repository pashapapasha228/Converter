package by.java.converter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConvertDTO {

    private Long id;

    private String currencyIn;
    private String currencyOut;
    private Double amountIn;
    private Double amountOut;

}
