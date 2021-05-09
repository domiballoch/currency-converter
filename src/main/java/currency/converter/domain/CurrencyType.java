package currency.converter.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CurrencyType {

    POUND("GBP", "£", "Pound Sterling", "Pound", "British Pound Sterling"),
    USD("USD", "$", "United States Dollar", "Dollar", "United States Dollar"),
    EURO("EUR", "", "Euro", "Euro", "Euro Member Countries"),
    YEN("JPY", "", "Japanese Yen", "Yen", "Japanese Yen"),
    YUAN("CNY", "", "Yuan Renminbi", "Yuan", "Chinese Yuan Renminbi");

    private String currencyTypeCode;
    private String symbol;
    private String currencyFullName;
    private String currencyShortName;
    private String description;

}
