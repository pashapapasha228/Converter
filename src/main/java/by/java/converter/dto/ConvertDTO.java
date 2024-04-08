package by.java.converter.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ConvertDTO {

    private Long id;

    private String currencyIn;
    private String currencyOut;
    private Double amountIn;
    private Double amountOut;

}
