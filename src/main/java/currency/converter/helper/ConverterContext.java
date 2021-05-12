package currency.converter.helper;

import currency.converter.strategy.Converter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConverterContext {

    private Converter converter;
}
