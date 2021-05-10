package currency.converter.service;

import currency.converter.domain.CurrencyType;
import currency.converter.helper.ConversionsHelper;
import currency.converter.strategy.Converter;
import currency.converter.utils.ConverterUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ConversionsHelper conversionsHelper;

    /**
     * Returns the conversion being made & the actual conversion amount
     *
     * @param amount
     * @param currencyType
     * @return Map of String & BigDecimal
     */
    @Override
    public Map<String, BigDecimal> getConversions(final BigDecimal amount, final CurrencyType currencyType) {
        final Converter converter = conversionsHelper.applyConversions(currencyType);
        return converter.convert(ConverterUtils.returnValueWithScale(amount));
    }
}
