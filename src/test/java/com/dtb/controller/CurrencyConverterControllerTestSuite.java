package com.dtb.controller;

import com.dtb.client.CurrencyConverterClient;
import com.dtb.domain.CurrencyDto;
import com.dtb.facade.CurrencyFacade;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(CurrencyConverterController.class)
class CurrencyConverterControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyConverterClient currencyConverterClient;

    @MockBean
    private CurrencyFacade currencyFacade;

    @Test
    void shouldGetConvertedCurrency() throws Exception {
        // Given
        String from = "USD";
        String to = "PLN";
        Optional<Double> amount = Optional.of(10.0);
        Double convertedAmount = 42.8;

        //When
        when(currencyConverterClient.getConvertedCurrency(from, to, amount)).thenReturn(convertedAmount);
        //Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/currencyConverter")
                        .contentType(MediaType.APPLICATION_JSON_VALUE));
    }
}