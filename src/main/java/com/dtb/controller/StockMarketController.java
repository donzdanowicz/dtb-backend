package com.dtb.controller;

import com.dtb.client.CurrencyConverterClient;
import com.dtb.client.StockMarketClient;
import com.dtb.domain.PriceDto;
import com.dtb.domain.StockMarketDto;
import com.dtb.domain.StockPriceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StockMarketController {

    private final StockMarketClient stockMarketClient;

    @GetMapping(value = "/stockMarket/price")
    public StockPriceDto getStockMarketPrice(@RequestParam String symbol) {
        return stockMarketClient.getPriceOfStock(symbol);
    }


}
