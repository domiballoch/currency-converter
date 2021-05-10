package currency.converter.strategy;

import currency.converter.config.ConfigProperties;
import currency.converter.domain.CurrencyType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static currency.converter.utils.ConverterConstants.AMOUNT;
import static currency.converter.utils.ConverterConstants.NEW_LINE;
import static currency.converter.utils.ConverterConstants.RESULT;
import static currency.converter.utils.ConverterConstants.SPACE;
import static currency.converter.utils.ConverterConstants.USD_TO_EUROS;
import static currency.converter.utils.ConverterConstants.USD_TO_POUNDS;
import static currency.converter.utils.ConverterConstants.USD_TO_YEN;
import static currency.converter.utils.ConverterConstants.USD_TO_YUAN;

@Slf4j
@Component
public class UsdConverter implements Converter {

    private final Map<String, BigDecimal> usdConversionsMap = new HashMap<>();

    private final ConfigProperties configProperties;

    public UsdConverter(ConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    @Override
    public Map<String, BigDecimal> convert(final BigDecimal amount) {
        usdToPounds(amount);
        usdToEuros(amount);
        usdToYen(amount);
        usdToYuan(amount);
        return usdConversionsMap;
    }

    public void usdToPounds(final BigDecimal amount) {
        BigDecimal usdToPounds = amount.multiply(configProperties.getUsd().get(CurrencyType.POUND));
        log.info(NEW_LINE + USD_TO_POUNDS +
                NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.USD.getCurrencyTypeCode() +
                NEW_LINE + RESULT + usdToPounds + SPACE + CurrencyType.POUND.getCurrencyTypeCode());
        usdConversionsMap.put(USD_TO_POUNDS, usdToPounds);
    }

    public void usdToEuros(final BigDecimal amount) {
        BigDecimal usdToEuros = amount.multiply(configProperties.getUsd().get(CurrencyType.EURO));
        log.info(NEW_LINE + USD_TO_EUROS +
                NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.USD.getCurrencyTypeCode() +
                NEW_LINE + RESULT + usdToEuros + SPACE + CurrencyType.EURO.getCurrencyTypeCode());
        usdConversionsMap.put(USD_TO_EUROS, usdToEuros);
    }

    public void usdToYen(final BigDecimal amount) {
        BigDecimal usdToYen = amount.multiply(configProperties.getUsd().get(CurrencyType.YEN));
        log.info(NEW_LINE + USD_TO_YEN +
                NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.USD.getCurrencyTypeCode() +
                NEW_LINE + RESULT + usdToYen + SPACE + CurrencyType.YEN.getCurrencyTypeCode());
        usdConversionsMap.put(USD_TO_YEN, usdToYen);
    }

    public void usdToYuan(final BigDecimal amount) {
        BigDecimal usdToYuan = amount.multiply(configProperties.getUsd().get(CurrencyType.YUAN));
        log.info(NEW_LINE + USD_TO_YUAN +
                NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.USD.getCurrencyTypeCode() +
                NEW_LINE + RESULT + usdToYuan + SPACE + CurrencyType.YUAN.getCurrencyTypeCode());
        usdConversionsMap.put(USD_TO_YUAN, usdToYuan);
    }
}
