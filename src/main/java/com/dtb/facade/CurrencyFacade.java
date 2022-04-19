package com.dtb.facade;

import com.dtb.domain.*;
import com.dtb.exception.CurrencyNotFoundException;
import com.dtb.mapper.CurrencyMapper;
import com.dtb.service.CurrencyAudDbService;
import com.dtb.service.CurrencyDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class CurrencyFacade {
    @Autowired
    private CurrencyDbService currencyDbService;
    @Autowired
    private CurrencyMapper currencyMapper;
    @Autowired
    private CurrencyAudDbService currencyAudDbService;

    public List<CurrencyDto> getCurrencies() {
        List<Currency> currencies = currencyDbService.getCurrencies();
        return currencyMapper.mapToCurrencyDtoList(currencies);
    }

    public CurrencyDto getCurrency(final Long id) throws CurrencyNotFoundException {
        return currencyMapper.mapToCurrencyDto(
                currencyDbService.getCurrency(id).orElseThrow(CurrencyNotFoundException::new)
        );
    }

    public void deleteCurrency(final Long id) throws CurrencyNotFoundException {
        CurrencyAud currencyAud = CurrencyAud.builder()
                .eventDate(LocalDate.now())
                .eventType("DELETE")
                .currencyId(id)
                .oldFrom(getCurrency(id).getFromCurrency())
                .oldTo(getCurrency(id).getToCurrency())
                .oldRate(getCurrency(id).getRate())
                .oldAmount(getCurrency(id).getAmount())
                .oldConvertedAmount(getCurrency(id).getConvertedAmount())
                .oldCreated(getCurrency(id).getCreated())
                .build();

        currencyAudDbService.saveCurrencyAud(currencyAud);

        currencyDbService.deleteCurrency(id);
    }

    public void createCurrency(final CurrencyDto currencyDto) throws CurrencyNotFoundException {
        Currency currency = currencyMapper.mapToCurrency(currencyDto);
        currency.setCreated(LocalDateTime.now());

        double rawRate = currency.getConvertedAmount() / currency.getAmount() * 100;
        int resultInt = (int) rawRate;
        double rate =  (double) resultInt/100;

        currency.setRate(rate);
        currencyDbService.saveCurrency(currency);

        CurrencyAud currencyAud = CurrencyAud.builder()
                .eventDate(LocalDate.now())
                .eventType("INSERT")
                .currencyId(getCurrencies().get(getCurrencies().size() - 1).getId())
                .newFrom(currencyDto.getFromCurrency())
                .newTo(currencyDto.getToCurrency())
                .newAmount(currencyDto.getAmount())
                .newConvertedAmount(currencyDto.getConvertedAmount())
                .newCreated(LocalDateTime.now())
                .build();

        currencyAudDbService.saveCurrencyAud(currencyAud);
    }

    public CurrencyDto updateCurrency(final CurrencyDto currencyDto) throws CurrencyNotFoundException {
        Long id = currencyDto.getId();

        CurrencyAud currencyAud = CurrencyAud.builder()
                .eventDate(LocalDate.now())
                .eventType("UPDATE")
                .currencyId(currencyDto.getId())
                .newFrom(currencyDto.getFromCurrency())
                .newTo(currencyDto.getToCurrency())
                .newRate(currencyDto.getRate())
                .newAmount(currencyDto.getAmount())
                .newConvertedAmount(currencyDto.getConvertedAmount())
                .newCreated(currencyDto.getCreated())
                .oldFrom(getCurrency(id).getFromCurrency())
                .oldTo(getCurrency(id).getToCurrency())
                .oldRate(getCurrency(id).getRate())
                .oldAmount(getCurrency(id).getAmount())
                .oldConvertedAmount(getCurrency(id).getConvertedAmount())
                .oldCreated(getCurrency(id).getCreated())
                .build();

        currencyAudDbService.saveCurrencyAud(currencyAud);

        Currency currency = currencyMapper.mapToCurrency(currencyDto);
        if(currency.getCreated() == null) currency.setCreated(getCurrency(id).getCreated());
        Currency updatedCurrency = currencyDbService.saveCurrency(currency);
        return currencyMapper.mapToCurrencyDto(updatedCurrency);
    }

    public Optional<CurrencyDto> getLatestCurrency(final String from, final String to) {
        List<CurrencyDto> currencies = getCurrencies();
        LocalDateTime date = currencies.stream()
                .filter(f -> f.getFromCurrency().equals(from))
                .filter(t -> t.getToCurrency().equals(to))
                .map(CurrencyDto::getCreated)
                .max(LocalDateTime::compareTo)
                .stream().findAny().get();

        Optional<CurrencyDto> latestCurrency = currencies.stream()
                .filter(c -> c.getCreated().equals(date))
                .findFirst();

        return latestCurrency;
    }

    public List<CurrencyDto> getLatest10() {
        List<Currency> currencies = currencyDbService.getLatest10();
        return currencyMapper.mapToCurrencyDtoList(currencies);
    }

}
