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
    private String stringCode1;
    private double amount1;
    private String stringCode2;
    private double amount2;

    public void getConvertation() {
        Money money1 = Money.of(amount1, stringCode1);

        if(MonetaryConversions.getExchangeRateProvider().getExchangeRate(stringCode1, stringCode2).isDerived()) {
            Money money2 = money1.with(MonetaryConversions.getExchangeRateProvider()
                    .getCurrencyConversion(stringCode2));
            amount2 = money2.getNumber().doubleValue();
        }

    }
}
