package currency.converter.controller;

import currency.converter.domain.CurrencyType;
import currency.converter.service.ClientService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
public class CurrencyController {

    @Autowired
    private ClientService clientService;

    @SneakyThrows
    @GetMapping(value = "/convert/{amount}/{currencyType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, BigDecimal>> conversionEndPoint(
            @PathVariable final BigDecimal amount, @PathVariable final CurrencyType currencyType) {
        final Map<String, BigDecimal> conversions = clientService.getConversions(amount, currencyType);
        return new ResponseEntity<>(conversions, HttpStatus.OK);
    }
}
