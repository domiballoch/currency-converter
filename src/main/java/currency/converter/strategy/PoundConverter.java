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
import static currency.converter.utils.ConverterConstants.POUNDS_TO_EUROS;
import static currency.converter.utils.ConverterConstants.POUNDS_TO_USD;
import static currency.converter.utils.ConverterConstants.POUNDS_TO_YEN;
import static currency.converter.utils.ConverterConstants.POUNDS_TO_YUAN;
import static currency.converter.utils.ConverterConstants.RESULT;
import static currency.converter.utils.ConverterConstants.SPACE;

@Slf4j
@Component
public class PoundConverter implements Converter {

    private final Map<String, BigDecimal> poundConversionsMap = new HashMap<>();

    private final ConfigProperties configProperties;

    public PoundConverter(ConfigProperties configProperties) {
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
        poundsToEuros(amount);
        poundsToUsd(amount);
        poundsToYen(amount);
        poundsToYuan(amount);
        return poundConversionsMap;
    }

    public void poundsToEuros(final BigDecimal amount) {
        BigDecimal poundsToEuros = amount.multiply(configProperties.getPound().get(CurrencyType.EURO));
        log.info(NEW_LINE + POUNDS_TO_EUROS +
                 NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.POUND.getCurrencyTypeCode() +
                 NEW_LINE + RESULT + poundsToEuros + SPACE + CurrencyType.EURO.getCurrencyTypeCode());
        poundConversionsMap.put(POUNDS_TO_EUROS, poundsToEuros);
    }

    public void poundsToUsd(final BigDecimal amount) {
        BigDecimal poundsToUsd = amount.multiply(configProperties.getPound().get(CurrencyType.USD));
        log.info(NEW_LINE + POUNDS_TO_USD +
                 NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.POUND.getCurrencyTypeCode() +
                 NEW_LINE + RESULT + poundsToUsd + SPACE + CurrencyType.USD.getCurrencyTypeCode());
        poundConversionsMap.put(POUNDS_TO_USD, poundsToUsd);
    }

    public void poundsToYen(final BigDecimal amount) {
        BigDecimal poundsToYen = amount.multiply(configProperties.getPound().get(CurrencyType.YEN));
        log.info(NEW_LINE + POUNDS_TO_YEN +
                 NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.POUND.getCurrencyTypeCode() +
                 NEW_LINE + RESULT + poundsToYen + SPACE + CurrencyType.YEN.getCurrencyTypeCode());
        poundConversionsMap.put(POUNDS_TO_YEN, poundsToYen);
    }

    public void poundsToYuan(final BigDecimal amount) {
        BigDecimal poundsToYuan = amount.multiply(configProperties.getPound().get(CurrencyType.YUAN));
        log.info(NEW_LINE + POUNDS_TO_YUAN +
                 NEW_LINE + AMOUNT + amount + SPACE + CurrencyType.POUND.getCurrencyTypeCode() +
                 NEW_LINE + RESULT + poundsToYuan + SPACE + CurrencyType.YUAN.getCurrencyTypeCode());
        poundConversionsMap.put(POUNDS_TO_YUAN, poundsToYuan);
    }
}
