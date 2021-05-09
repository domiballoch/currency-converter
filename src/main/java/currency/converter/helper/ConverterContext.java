package currency.converter.helper;

import currency.converter.strategy.Converter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ConverterContext {

    private Converter converter;
}
