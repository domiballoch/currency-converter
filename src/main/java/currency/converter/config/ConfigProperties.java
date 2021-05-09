package currency.converter.config;

import currency.converter.domain.CurrencyType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "exchange-rate")
public class ConfigProperties {



    private Map<CurrencyType, BigDecimal> pound;
    private Map<CurrencyType, BigDecimal> usd;
    private Map<CurrencyType, BigDecimal> euro;
    private Map<CurrencyType, BigDecimal> yen;
    private Map<CurrencyType, BigDecimal> yuan;
}
