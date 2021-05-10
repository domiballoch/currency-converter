package currency.converter.strategy;

import currency.converter.config.ConfigProperties;
import currency.converter.domain.CurrencyType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static currency.converter.utils.ConverterConstants.AMOUNT;
import static currency.converter.utils.ConverterConstants.EUROS_TO_POUNDS;
import static currency.converter.utils.ConverterConstants.EUROS_TO_USD;
import static currency.converter.utils.ConverterConstants.EUROS_TO_YEN;
import static currency.converter.utils.ConverterConstants.EUROS_TO_YUAN;
import static currency.converter.utils.ConverterConstants.NEW_LINE;
import static currency.converter.utils.ConverterConstants.RESULT;
import static currency.converter.utils.ConverterConstants.SPACE;

@Slf4j
@Component
public class EuroConverter implements Converter {

    private final Map<String, BigDecimal> euroConversionsMap = new HashMap<>();

    private final ConfigProperties configProperties;

    public EuroConverter(ConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    /**
     * Returns all conversion methods and calculation with String and BigDecimal
     *
     * @param amount
     * @return all conversion methods
     */
    @Override
    public Map<String, BigDecimal> convert(final BigDecimal amount) {
        eurosToPounds(amount);
        eurosToUsd(amount);
        eurosToYen(amount);
        eurosToYuan(amount);
        return euroConversionsMap;
    }

    public void eurosToPounds(final BigDecimal amount) {
        BigDecimal eurosToPounds = amount.multiply(configProperties.getEuro().get(CurrencyType.POUND));
        log.info(NEW_LINE + EUROS_TO_POUNDS +
                 NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.EURO.getCurrencyTypeCode() +
                 NEW_LINE + RESULT + eurosToPounds + SPACE + CurrencyType.POUND.getCurrencyTypeCode());
        euroConversionsMap.put(EUROS_TO_POUNDS, eurosToPounds);
    }

    public void eurosToUsd(final BigDecimal amount) {
        BigDecimal eurosToUsd = amount.multiply(configProperties.getEuro().get(CurrencyType.USD));
        log.info(NEW_LINE + EUROS_TO_USD +
                 NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.EURO.getCurrencyTypeCode() +
                 NEW_LINE + RESULT + eurosToUsd + SPACE + CurrencyType.USD.getCurrencyTypeCode());
        euroConversionsMap.put(EUROS_TO_USD, eurosToUsd);
    }

    public void eurosToYen(final BigDecimal amount) {
        BigDecimal eurosToYen = amount.multiply(configProperties.getEuro().get(CurrencyType.YEN));
        log.info(NEW_LINE + EUROS_TO_YEN +
                 NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.EURO.getCurrencyTypeCode() +
                 NEW_LINE + RESULT + eurosToYen + SPACE + CurrencyType.YEN.getCurrencyTypeCode());
        euroConversionsMap.put(EUROS_TO_YEN, eurosToYen);
    }

    public void eurosToYuan(final BigDecimal amount) {
        BigDecimal eurosToYuan = amount.multiply(configProperties.getEuro().get(CurrencyType.YUAN));
        log.info(NEW_LINE + EUROS_TO_YUAN +
                 NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.EURO.getCurrencyTypeCode() +
                 NEW_LINE + RESULT + eurosToYuan + SPACE + CurrencyType.YUAN.getCurrencyTypeCode());
        euroConversionsMap.put(EUROS_TO_YUAN, eurosToYuan);
    }
}
