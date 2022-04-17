package com.dtb.client;

import com.dtb.domain.PriceDto;
import com.dtb.domain.StockMarketDto;
import com.dtb.domain.StockPriceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class StockMarketClient {
    private final RestTemplate restTemplate;


    @Value("${stockMarket.api.endpoint}")
    private String stockMarketApiEndpoint;
    @Value("${currencies.api.key}")
    private String stockMarketApiKey;

    public StockPriceDto getPriceOfStock(String symbol) {
        URI url = UriComponentsBuilder.fromHttpUrl(stockMarketApiEndpoint)
                .queryParam("ticker_symbol", symbol)
                .build()
                .encode()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", "stock-market-data.p.rapidapi.com");
        headers.set("X-RapidAPI-Key", stockMarketApiKey);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<StockMarketDto> response = restTemplate.exchange(
                url, HttpMethod.GET, requestEntity, StockMarketDto.class);

        PriceDto priceDto = response.getBody().getPriceDto();
        StockPriceDto stockPriceDto = StockPriceDto.builder()
                .shortName(priceDto.getShortName())
                .currency(priceDto.getCurrency())
                .exchangeName(priceDto.getExchangeName())
                .symbol(priceDto.getSymbol())
                .price(priceDto.getRegularMarketPriceDto().getRaw())
                .build();

        return stockPriceDto;
    }
}
