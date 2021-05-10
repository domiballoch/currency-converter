package currency.converter.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import currency.converter.domain.CurrencyType;
import currency.converter.service.ClientService;
import currency.converter.utils.TestUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;
import java.util.Map;

import static currency.converter.utils.RestControllerTestHelper.getResponseFrom;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CurrencyController.class)
public class CurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ClientService clientService;

    /**
     * MockMvc test to check controller is being called
     * Test data can be swapped out with different data using TestUtils
     * //TODO:Need to add proper integration test
     */
    @SneakyThrows
    @Test
    public void testClientConverter_pound() {
        when(clientService.getConversions(new BigDecimal("100"), CurrencyType.POUND))
                .thenReturn(TestUtils.returnTestResponse_pounds());
        final ResultActions resultActions =
                mockMvc.perform(get("/convert/{amount}/{currencyType}", 100, "POUND")
                        .accept(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isOk());
                        //.andExpect(jsonPath("$.isbn").value(4));

        final Map<String, BigDecimal> result = getResponseFrom(resultActions, objectMapper, new TypeReference<>() {});
        assertThat(result).isEqualTo(TestUtils.returnTestResponse_pounds());
        verify(clientService, times(1)).getConversions(any(BigDecimal.class), any(CurrencyType.class));
    }
}
