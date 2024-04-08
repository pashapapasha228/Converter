package by.java.converter.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RequestDTO {

    private Double amountIn;
    private String currencyIn;
    private List<String> currenciesOut;

}
