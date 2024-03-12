package by.java.converter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.javamoney.moneta.Money;

import javax.money.convert.MonetaryConversions;

@Data
@Builder
@AllArgsConstructor
public class Converter {
    private String currencyIn;
    private double amountIn;
    private String currencyOut;
    private double amountOut;

    public void getConversion() {
        Money money1 = Money.of(amountIn, currencyIn);

        Money money2 = money1.with(MonetaryConversions.getExchangeRateProvider()
                    .getCurrencyConversion(currencyOut));
        amountOut = money2.getNumber().doubleValue();
    }
}
