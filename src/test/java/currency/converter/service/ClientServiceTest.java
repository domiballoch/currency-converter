package currency.converter.service;

import currency.converter.domain.CurrencyType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static currency.converter.utils.ConverterConstants.*;

@SpringBootTest
public class ClientServiceTest {

    @Autowired
    private ClientServiceImpl clientService;

    @Test
    public void shouldApplyPoundConverter() {
        final Map<String, BigDecimal> amount =
                clientService.getConversions(new BigDecimal("100.00"), CurrencyType.POUND);
        assertThat(amount.get(POUNDS_TO_EUROS)).isEqualByComparingTo(new BigDecimal("115.009540000"));
        assertThat(amount.get(POUNDS_TO_USD)).isEqualByComparingTo(new BigDecimal("139.893170000"));
        assertThat(amount.get(POUNDS_TO_YEN)).isEqualByComparingTo(new BigDecimal("15187.590000"));
        assertThat(amount.get(POUNDS_TO_YUAN)).isEqualByComparingTo(new BigDecimal("899.730140000"));
    }

    @Test
    public void shouldApplyUsdConverter() {
        final Map<String, BigDecimal> amount =
                clientService.getConversions(new BigDecimal("100.00"), CurrencyType.USD);
        assertThat(amount.get(USD_TO_POUNDS)).isEqualByComparingTo(new BigDecimal("071.483119000"));
        assertThat(amount.get(USD_TO_EUROS)).isEqualByComparingTo(new BigDecimal("082.212403000"));
        assertThat(amount.get(USD_TO_YEN)).isEqualByComparingTo(new BigDecimal("10856.563000000"));
        assertThat(amount.get(USD_TO_YUAN)).isEqualByComparingTo(new BigDecimal("643.155160000"));
    }

    @Test
    public void shouldApplyEuroConverter() {
        final Map<String, BigDecimal> amount =
                clientService.getConversions(new BigDecimal("100.00"), CurrencyType.EURO);
        assertThat(amount.get(EUROS_TO_POUNDS)).isEqualByComparingTo(new BigDecimal("086.949312000"));
        assertThat(amount.get(EUROS_TO_USD)).isEqualByComparingTo(new BigDecimal("121.636150000"));
        assertThat(amount.get(EUROS_TO_YEN)).isEqualByComparingTo(new BigDecimal("13205.505000000"));
        assertThat(amount.get(EUROS_TO_YUAN)).isEqualByComparingTo(new BigDecimal("782.309160000"));
    }

    @Test
    public void shouldApplyYenConverter() {
        final Map<String, BigDecimal> amount =
                clientService.getConversions(new BigDecimal("100.00"), CurrencyType.YEN);
        assertThat(amount.get(YEN_TO_POUNDS)).isEqualByComparingTo(new BigDecimal("000.658432330"));
        assertThat(amount.get(YEN_TO_EUROS)).isEqualByComparingTo(new BigDecimal("000.757259960"));
        assertThat(amount.get(YEN_TO_USD)).isEqualByComparingTo(new BigDecimal("000.921101850"));
        assertThat(amount.get(YEN_TO_YUAN)).isEqualByComparingTo(new BigDecimal("005.924114100"));
    }

    @Test
    public void shouldApplyYuanConverter() {
        final Map<String, BigDecimal> amount =
                clientService.getConversions(new BigDecimal("100.00"), CurrencyType.YUAN);
        assertThat(amount.get(YUAN_TO_POUNDS)).isEqualByComparingTo(new BigDecimal("011.114444000"));
        assertThat(amount.get(YUAN_TO_EUROS)).isEqualByComparingTo(new BigDecimal("012.782670000"));
        assertThat(amount.get(YUAN_TO_USD)).isEqualByComparingTo(new BigDecimal("015.548348000"));
        assertThat(amount.get(YUAN_TO_YEN)).isEqualByComparingTo(new BigDecimal("1688.016100000"));
    }
}
