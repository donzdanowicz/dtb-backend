package com.dtb.controller;

import com.dtb.client.CurrencyConverterClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CurrencyConverterController {

    private final CurrencyConverterClient currencyConverterClient;

    @GetMapping(value = "/currencyConverter")
    public Double getConvertedAmount(@RequestParam String from, @RequestParam String to,
                                     @RequestParam Optional<Double> amountFrom) {
        double convertedValue = currencyConverterClient.getConvertedCurrency(from, to, amountFrom);
        double convertedAmount = amountFrom.orElse(1.0);
        double result = convertedValue * convertedAmount * 100;
        int resultInt = (int) result;
        return (double) resultInt/100;
    }
}
