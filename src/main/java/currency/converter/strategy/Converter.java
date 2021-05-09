package currency.converter.strategy;

import java.math.BigDecimal;
import java.util.Map;

public interface Converter {

    Map<String, BigDecimal> convert(final BigDecimal amount);
}
