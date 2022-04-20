package com.dtb.controller;

import com.dtb.domain.CurrencyDto;
import com.dtb.facade.CurrencyFacade;
import com.google.gson.Gson;
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
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(CurrencyController.class)
class CurrencyControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyFacade currencyFacade;

    @Test
    public void shouldGetEmptyListOfCurrencies() throws Exception {
        //Given
        when(currencyFacade.getCurrencies()).thenReturn(List.of());

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/currencies")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void shouldGetCurrencies() throws Exception {
        // Given
        CurrencyDto currencyDto = CurrencyDto.builder()
                .id(1L)
                .fromCurrency("USD")
                .toCurrency("CAD")
                .rate(1.26)
                .amount(10)
                .convertedAmount(12.6)
                .created(LocalDateTime.now())
                .build();

        List<CurrencyDto> currenciesDto = List.of(currencyDto);

        //When
        when(currencyFacade.getCurrencies()).thenReturn(currenciesDto);

        //Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/currencies")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].fromCurrency", Matchers.is("USD")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].toCurrency", Matchers.is("CAD")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rate", Matchers.is(1.26)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].fromCurrency", Matchers.is("USD")));
    }

    @Test
    public void shouldDeleteCurrency() throws Exception {
        //Given & When

        //Then
        mockMvc.
                perform(MockMvcRequestBuilders
                        .delete("/v1/currencies/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void shouldUpdateCurrency() throws Exception {
        // Given
        CurrencyDto currencyDto = CurrencyDto.builder()
                .id(1L)
                .fromCurrency("USD")
                .toCurrency("CAD")
                .rate(1.26)
                .amount(10)
                .convertedAmount(12.6)
                .build();

        when(currencyFacade.updateCurrency(currencyDto)).thenReturn(currencyDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(currencyDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/currencies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fromCurrency", Matchers.is("USD")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.toCurrency", Matchers.is("CAD")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rate", Matchers.is(1.26)));
    }

    @Test
    void shouldCreateCurrency() throws Exception {
        // Given
        CurrencyDto currencyDto = CurrencyDto.builder()
                .id(1L)
                .fromCurrency("USD")
                .toCurrency("CAD")
                .rate(1.26)
                .amount(10)
                .convertedAmount(12.6)
                .build();

        Gson gson = new Gson();
        String jsonContent = gson.toJson(currencyDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/currencies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}