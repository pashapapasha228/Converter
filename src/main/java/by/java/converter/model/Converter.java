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
    private String index1;
    private double value1;
    private String index2;
    private double value2;

    public void getConvertation() {
        Money money1 = Money.of(value1, index1);

        if(MonetaryConversions.getExchangeRateProvider().getExchangeRate(index1, index2).isDerived()) {
            Money money2 = money1.with(MonetaryConversions.getExchangeRateProvider().getCurrencyConversion(index2));
            value2 = money2.getNumber().doubleValue();
        }

    }
}
