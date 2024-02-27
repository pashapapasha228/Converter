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
    private String string_code1;
    private double amount1;
    private String string_code2;
    private double amount2;

    public void getConvertation() {
        Money money1 = Money.of(amount1, string_code1);

        if(MonetaryConversions.getExchangeRateProvider().getExchangeRate(string_code1, string_code2).isDerived()) {
            Money money2 = money1.with(MonetaryConversions.getExchangeRateProvider()
                    .getCurrencyConversion(string_code2));
            amount2 = money2.getNumber().doubleValue();
        }

    }
}
