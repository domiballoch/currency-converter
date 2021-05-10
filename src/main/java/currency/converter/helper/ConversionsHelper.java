package currency.converter.helper;

import currency.converter.config.ConfigProperties;
import currency.converter.domain.CurrencyType;
import currency.converter.strategy.Converter;
import currency.converter.strategy.EuroConverter;
import currency.converter.strategy.PoundConverter;
import currency.converter.strategy.UsdConverter;
import currency.converter.strategy.YenConverter;
import currency.converter.strategy.YuanConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static currency.converter.utils.ConverterConstants.INVALID_TYPE;

@Slf4j
@Component
public class ConversionsHelper {

    @Autowired
    private ConverterContext converterContext;

    @Autowired
    private ConfigProperties configProperties;

    @Autowired
    private PoundConverter poundConverter;

    @Autowired
    private UsdConverter usdConverter;

    @Autowired
    private EuroConverter euroConverter;

    @Autowired
    private YenConverter yenConverter;

    @Autowired
    private YuanConverter yuanConverter;

    /**
     * Returns Converter dynamically based on Currency Type
     *
     * @param currencyType
     * @return Converter Interface
     */
    public Converter applyConversions(CurrencyType currencyType) {
        switch (currencyType) {
            case POUND:
                converterContext.setConverter(poundConverter);
                break;
            case USD:
                converterContext.setConverter(usdConverter);
                break;
            case EURO:
                converterContext.setConverter(euroConverter);
                break;
            case YEN:
                converterContext.setConverter(yenConverter);
                break;
            case YUAN:
                converterContext.setConverter(yuanConverter);
                break;
            default:
                throw new IllegalArgumentException(INVALID_TYPE + currencyType);
        }
        return converterContext.getConverter();
    }
}
