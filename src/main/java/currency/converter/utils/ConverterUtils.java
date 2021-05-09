package currency.converter.utils;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.math.RoundingMode;

@UtilityClass
public class ConverterUtils {

    public BigDecimal returnValueWithScale(final BigDecimal value) {
        return value.setScale(10, RoundingMode.HALF_UP) ;
    }
}
