package com.dtb.mapper;

import com.dtb.domain.Currency;
import com.dtb.domain.CurrencyDto;
import com.dtb.exception.CurrencyNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CurrencyMapperTestSuite {

    @Autowired
    private CurrencyMapper currencyMapper;

    @Test
    public void shouldMapToCurrency() throws CurrencyNotFoundException {
        //Given
        CurrencyDto currencyDto = CurrencyDto.builder()
                .id(1L)
                .fromCurrency("USD")
                .toCurrency("PLN")
                .rate(4.28)
                .amount(2)
                .convertedAmount(8.56)
                .created(LocalDateTime.of(2022, 4, 1, 8, 30, 0))
                .build();

        //When
        Currency currency = currencyMapper.mapToCurrency(currencyDto);

        //Then
        assertEquals(1L, currency.getId());
        assertEquals("USD", currency.getFromCurrency());
        assertEquals("PLN", currency.getToCurrency());
        assertEquals(4.28, currency.getRate());
        assertEquals(2, currency.getAmount());
        assertEquals(8.56, currency.getConvertedAmount());
        assertEquals(LocalDateTime.of(2022, 4, 1, 8, 30, 0), currency.getCreated());
    }

    @Test
    public void shouldMapToCurrencyDto() throws CurrencyNotFoundException {
        //Given
        Currency currency = Currency.builder()
                .id(1L)
                .fromCurrency("USD")
                .toCurrency("PLN")
                .rate(4.28)
                .amount(2)
                .convertedAmount(8.56)
                .created(LocalDateTime.of(2022, 4, 1, 8, 30, 0))
                .build();

        //When
        CurrencyDto currencyDto = currencyMapper.mapToCurrencyDto(currency);

        //Then
        assertEquals(1L, currencyDto.getId());
        assertEquals("USD", currencyDto.getFromCurrency());
        assertEquals("PLN", currencyDto.getToCurrency());
        assertEquals(4.28, currencyDto.getRate());
        assertEquals(2, currencyDto.getAmount());
        assertEquals(8.56, currencyDto.getConvertedAmount());
        assertEquals(LocalDateTime.of(2022, 4, 1, 8, 30, 0), currency.getCreated());
    }

    @Test
    public void shouldMapToCurrencyDtoList() throws CurrencyNotFoundException {
        //Given
        List<Currency> currencies = new ArrayList<>();
        Currency currency1 = Currency.builder()
                .id(1L)
                .fromCurrency("USD")
                .toCurrency("PLN")
                .rate(4.28)
                .amount(2)
                .convertedAmount(8.56)
                .created(LocalDateTime.of(2022, 4, 1, 8, 30, 0))
                .build();

        Currency currency2 = Currency.builder()
                .id(2L)
                .fromCurrency("USD")
                .toCurrency("CAD")
                .rate(1.26)
                .amount(4)
                .convertedAmount(5.04)
                .created(LocalDateTime.of(2022, 4, 11, 12, 30, 0))
                .build();

        currencies.add(currency1);
        currencies.add(currency2);

        //When
        List<CurrencyDto> currenciesDto = currencyMapper.mapToCurrencyDtoList(currencies);

        //Then
        assertEquals(2, currenciesDto.size());
        assertEquals(1L, currenciesDto.get(0).getId());
        assertEquals("USD", currenciesDto.get(0).getFromCurrency());
        assertEquals("PLN", currenciesDto.get(0).getToCurrency());
        assertEquals(1.26, currenciesDto.get(1).getRate());
        assertEquals(4, currenciesDto.get(1).getAmount());
        assertEquals(5.04, currenciesDto.get(1).getConvertedAmount());
        assertEquals(LocalDateTime.of(2022, 4, 11, 12, 30, 0),
                currenciesDto.get(1).getCreated());

    }



}

