package com.dtb.controller;

import com.dtb.client.CurrencyConverterClient;
import com.dtb.client.StockMarketClient;
import com.dtb.domain.PriceDto;
import com.dtb.domain.StockMarketDto;
import com.dtb.domain.StockPriceAud;
import com.dtb.domain.StockPriceDto;
import com.dtb.service.StockPriceAudDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StockMarketController {

    private final StockMarketClient stockMarketClient;
    private final StockPriceAudDbService stockPriceAudDbService;

    @GetMapping(value = "/stockMarket/price")
    public StockPriceDto getStockMarketPrice(@RequestParam String symbol) {
        StockPriceDto stockPriceDto = stockMarketClient.getPriceOfStock(symbol);

        StockPriceAud stockPriceAud = StockPriceAud.builder()
                .eventDate(LocalDate.now())
                .shortName(stockPriceDto.getShortName())
                .currency(stockPriceDto.getCurrency())
                .exchangeName(stockPriceDto.getExchangeName())
                .symbol(stockPriceDto.getSymbol())
                .price(stockPriceDto.getPrice())
                .build();

        stockPriceAudDbService.saveStockPriceAud(stockPriceAud);

        return stockPriceDto;
    }


}
