package currency.converter.service;

import currency.converter.domain.CurrencyType;

import java.math.BigDecimal;
import java.util.Map;

public interface ClientService {

    Map<String, BigDecimal> getConversions(final BigDecimal amount, final CurrencyType currencyType);
}
