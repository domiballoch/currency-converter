package currency.converter.strategy;

import currency.converter.config.ConfigProperties;
import currency.converter.domain.CurrencyType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static currency.converter.utils.ConverterConstants.AMOUNT;
import static currency.converter.utils.ConverterConstants.YEN_TO_POUNDS;
import static currency.converter.utils.ConverterConstants.YEN_TO_USD;
import static currency.converter.utils.ConverterConstants.YEN_TO_EUROS;
import static currency.converter.utils.ConverterConstants.YEN_TO_YUAN;
import static currency.converter.utils.ConverterConstants.NEW_LINE;
import static currency.converter.utils.ConverterConstants.RESULT;
import static currency.converter.utils.ConverterConstants.SPACE;

@Slf4j
@Component
public class YenConverter implements Converter {

    private final Map<String, BigDecimal> yenConversionsMap = new HashMap<>();

    private final ConfigProperties configProperties;

    public YenConverter(ConfigProperties configProperties) {
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
        yenToPounds(amount);
        yenToUsd(amount);
        yenToEuros(amount);
        yenToYuan(amount);
        return yenConversionsMap;
    }

    public void yenToPounds(final BigDecimal amount) {
        BigDecimal yenToPounds = amount.multiply(configProperties.getYen().get(CurrencyType.POUND));
        log.info(NEW_LINE + YEN_TO_POUNDS +
                NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.YEN.getCurrencyTypeCode() +
                NEW_LINE + RESULT + yenToPounds + SPACE + CurrencyType.POUND.getCurrencyTypeCode());
        yenConversionsMap.put(YEN_TO_POUNDS, yenToPounds);
    }

    public void yenToUsd(final BigDecimal amount) {
        BigDecimal yenToUsd = amount.multiply(configProperties.getYen().get(CurrencyType.USD));
        log.info(NEW_LINE + YEN_TO_USD +
                NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.YEN.getCurrencyTypeCode() +
                NEW_LINE + RESULT + yenToUsd + SPACE + CurrencyType.USD.getCurrencyTypeCode());
        yenConversionsMap.put(YEN_TO_USD, yenToUsd);
    }

    public void yenToEuros(final BigDecimal amount) {
        BigDecimal yenToEuros = amount.multiply(configProperties.getYen().get(CurrencyType.EURO));
        log.info(NEW_LINE + YEN_TO_EUROS +
                NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.YEN.getCurrencyTypeCode() +
                NEW_LINE + RESULT + yenToEuros + SPACE + CurrencyType.EURO.getCurrencyTypeCode());
        yenConversionsMap.put(YEN_TO_EUROS, yenToEuros);
    }

    public void yenToYuan(final BigDecimal amount) {
        BigDecimal yenToYuan = amount.multiply(configProperties.getYen().get(CurrencyType.YUAN));
        log.info(NEW_LINE + YEN_TO_YUAN +
                NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.YEN.getCurrencyTypeCode() +
                NEW_LINE + RESULT + yenToYuan + SPACE + CurrencyType.YUAN.getCurrencyTypeCode());
        yenConversionsMap.put(YEN_TO_YUAN, yenToYuan);
    }
}
