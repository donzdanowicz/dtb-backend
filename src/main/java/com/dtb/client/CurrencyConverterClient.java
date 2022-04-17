package com.dtb.client;

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
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CurrencyConverterClient {
    private final RestTemplate restTemplate;


    @Value("${currencies.api.endpoint}")
    private String currenciesApiEndpoint;
    @Value("${currencies.api.key}")
    private String currenciesApiKey;

    public Double getConvertedCurrency(String from, String to, Optional<Double> amountFrom) {
        URI url = UriComponentsBuilder.fromHttpUrl(currenciesApiEndpoint)
                .queryParam("from", from)
                .queryParam("to", to)
                .queryParamIfPresent("q", amountFrom)
                .build()
                .encode()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Host", "currency-exchange.p.rapidapi.com");
        headers.set("X-RapidAPI-Key", currenciesApiKey);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, requestEntity, String.class);

        Double convertedValue = Double.parseDouble(response.getBody());


        return convertedValue;
    }
}

