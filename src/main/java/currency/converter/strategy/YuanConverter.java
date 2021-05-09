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
import static currency.converter.utils.ConverterConstants.YUAN_TO_EUROS;
import static currency.converter.utils.ConverterConstants.YUAN_TO_POUNDS;
import static currency.converter.utils.ConverterConstants.YUAN_TO_USD;
import static currency.converter.utils.ConverterConstants.YUAN_TO_YEN;

@Slf4j
@Component
public class YuanConverter implements Converter {

    private final Map<String, BigDecimal> yuanConversionsMap = new HashMap<>();

    private final ConfigProperties configProperties;

    public YuanConverter(ConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    @Override
    public Map<String, BigDecimal> convert(final BigDecimal amount) {
        yuanToPounds(amount);
        yuanToUsd(amount);
        yuanToEuros(amount);
        yuanToYen(amount);
        return yuanConversionsMap;
    }

    public void yuanToPounds(final BigDecimal amount) {
        BigDecimal yuanToPounds = amount.multiply(configProperties.getEuro().get(CurrencyType.POUND));
        log.info(NEW_LINE + YUAN_TO_POUNDS +
                NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.YUAN.getCurrencyTypeCode() +
                NEW_LINE + RESULT + yuanToPounds + SPACE + CurrencyType.POUND.getCurrencyTypeCode());
        yuanConversionsMap.put(YUAN_TO_POUNDS, yuanToPounds);
    }

    public void yuanToUsd(final BigDecimal amount) {
        BigDecimal yuanToUsd = amount.multiply(configProperties.getEuro().get(CurrencyType.USD));
        log.info(NEW_LINE + YUAN_TO_USD +
                NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.YUAN.getCurrencyTypeCode() +
                NEW_LINE + RESULT + yuanToUsd + SPACE + CurrencyType.USD.getCurrencyTypeCode());
        yuanConversionsMap.put(YUAN_TO_USD, yuanToUsd);
    }

    public void yuanToEuros(final BigDecimal amount) {
        BigDecimal yuanToEuros = amount.multiply(configProperties.getEuro().get(CurrencyType.EURO));
        log.info(NEW_LINE + YUAN_TO_EUROS +
                NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.YUAN.getCurrencyTypeCode() +
                NEW_LINE + RESULT + yuanToEuros + SPACE + CurrencyType.EURO.getCurrencyTypeCode());
        yuanConversionsMap.put(YUAN_TO_EUROS, yuanToEuros);
    }

    public void yuanToYen(final BigDecimal amount) {
        BigDecimal yuanToYen = amount.multiply(configProperties.getEuro().get(CurrencyType.YEN));
        log.info(NEW_LINE + YUAN_TO_YEN +
                NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.YUAN.getCurrencyTypeCode() +
                NEW_LINE + RESULT + yuanToYen + SPACE + CurrencyType.YEN.getCurrencyTypeCode());
        yuanConversionsMap.put(YUAN_TO_YEN, yuanToYen);
    }
}
