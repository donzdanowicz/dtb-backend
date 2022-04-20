package com.dtb.service;

import com.dtb.domain.CurrencyAud;
import com.dtb.repository.CurrencyAudRepository;
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
class CurrencyAudDbServiceTestSuite {

    @InjectMocks
    CurrencyAudDbService currencyAudDbService;

    @Mock
    CurrencyAudRepository currencyAudRepository;

    @Test
    void saveCurrencyAud() {
        //Given
        CurrencyAud currencyAud = CurrencyAud.builder()
                .eventDate(LocalDate.now())
                .eventType("INSERT")
                .currencyId(1L)
                .newFromCurrency("USD")
                .newToCurrency("CAD")
                .newRate(1.26)
                .newAmount(10)
                .newConvertedAmount(12.6)
                .newCreated(LocalDateTime.now())
                .build();

        when(currencyAudRepository.findById(1L)).thenReturn(Optional.of(currencyAud));

        //When
        currencyAudDbService.saveCurrencyAud(currencyAud);

        //Then
        assertEquals("INSERT", currencyAudRepository.findById(1L).get().getEventType());
        assertEquals(1L, currencyAudRepository.findById(1L).get().getCurrencyId());
        assertEquals("USD", currencyAudRepository.findById(1L).get().getNewFromCurrency());
        assertEquals("CAD", currencyAudRepository.findById(1L).get().getNewToCurrency());
        assertEquals(1.26, currencyAudRepository.findById(1L).get().getNewRate());
        assertEquals(10, currencyAudRepository.findById(1L).get().getNewAmount());
        assertEquals(12.6, currencyAudRepository.findById(1L).get().getNewConvertedAmount());
    }
}
