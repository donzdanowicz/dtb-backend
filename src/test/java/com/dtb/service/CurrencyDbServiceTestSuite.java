package com.dtb.service;

import com.dtb.domain.Currency;
import com.dtb.domain.CurrencyAud;
import com.dtb.repository.CurrencyAudRepository;
import com.dtb.repository.CurrencyRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CurrencyDbServiceTestSuite {

    @InjectMocks
    CurrencyDbService currencyDbService;

    @Mock
    CurrencyRepository currencyRepository;

    @Test
    void getCurrencies() {
        //Given
        List<Currency> currencyList = new ArrayList<>();

        Currency currency1 = Currency.builder()
                .id(1L)
                .fromCurrency("USD")
                .toCurrency("CAD")
                .rate(1.26)
                .amount(10)
                .convertedAmount(12.6)
                .created(LocalDateTime.now())
                .build();

        Currency currency2 = Currency.builder()
                .id(2L)
                .fromCurrency("USD")
                .toCurrency("PLN")
                .rate(4.28)
                .amount(10)
                .convertedAmount(42.8)
                .created(LocalDateTime.now())
                .build();


        currencyList.add(currency1);
        currencyList.add(currency2);
        when(currencyRepository.findAll()).thenReturn(currencyList);

        //When
        List<Currency> result = currencyDbService.getCurrencies();

        //Then
        assertEquals(2, result.size());
    }

    @Test
    void getCurrency() {
        //Given
        Currency currency = Currency.builder()
                .id(1L)
                .fromCurrency("USD")
                .toCurrency("CAD")
                .rate(1.26)
                .amount(10)
                .convertedAmount(12.6)
                .created(LocalDateTime.now())
                .build();

        when(currencyRepository.findById(1L)).thenReturn(Optional.of(currency));

        //When
        Optional<Currency> result = currencyDbService.getCurrency(1L);

        //Then
        assertEquals(Optional.of(currency), currencyDbService.getCurrency(1L));
    }

    @Test
    void deleteCurrency() {
        //Given
        Currency currency = Currency.builder()
                .id(1L)
                .fromCurrency("USD")
                .toCurrency("CAD")
                .rate(1.26)
                .amount(10)
                .convertedAmount(12.6)
                .created(LocalDateTime.now())
                .build();

        //When
        currencyDbService.deleteCurrency(1L);

        //Then
        assertEquals(Optional.empty(), currencyDbService.getCurrency(1L));
    }

    @Test
    void saveCurrency() {
        //Given
        Currency currency = Currency.builder()
                .id(1L)
                .fromCurrency("USD")
                .toCurrency("CAD")
                .rate(1.26)
                .amount(10)
                .convertedAmount(12.6)
                .created(LocalDateTime.now())
                .build();

        when(currencyRepository.findById(1L)).thenReturn(Optional.of(currency));

        //When
        currencyDbService.saveCurrency(currency);

        //Then
        assertEquals("USD", currencyRepository.findById(1L).get().getFromCurrency());
        assertEquals("CAD", currencyRepository.findById(1L).get().getToCurrency());
        assertEquals(1.26, currencyRepository.findById(1L).get().getRate());
        assertEquals(10, currencyRepository.findById(1L).get().getAmount());
        assertEquals(12.6, currencyRepository.findById(1L).get().getConvertedAmount());
    }
}
