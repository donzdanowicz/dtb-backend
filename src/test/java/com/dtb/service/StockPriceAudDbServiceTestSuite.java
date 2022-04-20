package com.dtb.service;

import com.dtb.domain.CurrencyAud;
import com.dtb.domain.StockPriceAud;
import com.dtb.repository.StockPriceAudRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StockPriceAudDbServiceTestSuite {

    @InjectMocks
    StockPriceAudDbService stockPriceAudDbService;

    @Mock
    StockPriceAudRepository stockPriceAudRepository;

    @Test
    void saveStockPriceAud() {
        //Given
        StockPriceAud stockPriceAud = StockPriceAud.builder()
                .eventDate(LocalDate.now())
                .shortName("Apple Inc.")
                .currency("USD")
                .exchangeName("NasdaqGS")
                .symbol("AAPL")
                .price(165.2)
                .build();

        when(stockPriceAudRepository.findById(1L)).thenReturn(Optional.of(stockPriceAud));

        //When
        stockPriceAudDbService.saveStockPriceAud(stockPriceAud);

        //Then
        assertEquals("Apple Inc.", stockPriceAudRepository.findById(1L).get().getShortName());
        assertEquals("USD", stockPriceAudRepository.findById(1L).get().getCurrency());
        assertEquals("NasdaqGS", stockPriceAudRepository.findById(1L).get().getExchangeName());
        assertEquals("AAPL", stockPriceAudRepository.findById(1L).get().getSymbol());
        assertEquals(165.2, stockPriceAudRepository.findById(1L).get().getPrice());
    }
}
