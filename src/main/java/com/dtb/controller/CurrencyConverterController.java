package com.dtb.controller;

import com.dtb.client.CurrencyConverterClient;
import com.dtb.domain.Currency;
import com.dtb.domain.CurrencyDto;
import com.dtb.exception.CurrencyNotFoundException;
import com.dtb.facade.CurrencyFacade;
import com.dtb.service.CurrencyDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CurrencyConverterController {

    private final CurrencyConverterClient currencyConverterClient;
    private final CurrencyFacade currencyFacade;

    @GetMapping(value = "/currencyConverter")
    public Double getConvertedAmount(@RequestParam String from, @RequestParam String to,
                                     @RequestParam Optional<Double> amountFrom) throws CurrencyNotFoundException {
        double convertedValue = currencyConverterClient.getConvertedCurrency(from, to, amountFrom);
        double convertedAmount = amountFrom.orElse(1.0);
        double result = convertedValue * convertedAmount * 100;
        int resultInt = (int) result;
        double finalAmount = (double) resultInt/100;

        CurrencyDto currencyDto = CurrencyDto.builder()
                .fromCurrency(from)
                .toCurrency(to)
                .amount(amountFrom.orElse(1.0))
                .convertedAmount(finalAmount)
                .rate(convertedValue)
                .created(LocalDateTime.now())
                .build();

        currencyFacade.createCurrency(currencyDto);

        return finalAmount;
    }
}
