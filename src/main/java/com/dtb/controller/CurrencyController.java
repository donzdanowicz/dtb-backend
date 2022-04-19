package com.dtb.controller;

import com.dtb.domain.Currency;
import com.dtb.domain.CurrencyDto;
import com.dtb.domain.UserDto;
import com.dtb.exception.CurrencyNotFoundException;
import com.dtb.exception.UserNotFoundException;
import com.dtb.facade.CurrencyFacade;
import com.dtb.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
public class CurrencyController {
    private final CurrencyFacade currencyFacade;

    @GetMapping(value = "/currencies")
    public List<CurrencyDto> getCurrencies() {
        return currencyFacade.getCurrencies();
    }

    @GetMapping(value = "/currencies/{id}")
    public CurrencyDto getCurrency(@PathVariable Long id) throws CurrencyNotFoundException {
        return currencyFacade.getCurrency(id);
    }

    @DeleteMapping(value = "/currencies/{id}")
    public void deleteCurrency(@PathVariable Long id) throws CurrencyNotFoundException {
        currencyFacade.deleteCurrency(id);
    }

    @PostMapping(value = "/currencies", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCurrency(@RequestBody CurrencyDto currencyDto) throws CurrencyNotFoundException {
        currencyFacade.createCurrency(currencyDto);
    }

    @PutMapping(value = "/currencies")
    public CurrencyDto updateCurrency(@RequestBody CurrencyDto currencyDto) throws CurrencyNotFoundException {
        return currencyFacade.updateCurrency(currencyDto);
    }

    @GetMapping(value = "/currencies/latest")
    public CurrencyDto getLatestCurrency(@RequestParam String from, @RequestParam String to) {
//        List<CurrencyDto> currencies = currencyFacade.getCurrencies();
//        LocalDateTime date = currencies.stream()
//                .filter(f -> f.getFromCurrency().equals(from))
//                .filter(t -> t.getToCurrency().equals(to))
//                .map(CurrencyDto::getCreated)
//                .max(LocalDateTime::compareTo)
//                .stream().findAny().get();
//
//        Optional<CurrencyDto> latestCurrency = currencies.stream()
//                .filter(c -> c.getCreated().equals(date))
//                .findFirst();
//
//        return latestCurrency;

        return currencyFacade.getLatestCurrency(from, to).get();
    }

    @GetMapping(value = "/currencies/latest10")
    public List<CurrencyDto> getLatest10() {
        return currencyFacade.getLatest10();
    }
}
