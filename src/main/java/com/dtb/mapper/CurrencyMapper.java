package com.dtb.mapper;

import com.dtb.domain.Currency;
import com.dtb.domain.CurrencyDto;
import com.dtb.domain.Entry;
import com.dtb.domain.EntryDto;
import com.dtb.exception.CurrencyNotFoundException;
import com.dtb.exception.UserNotFoundException;
import com.dtb.repository.CurrencyRepository;
import com.dtb.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CurrencyMapper {
    private CurrencyRepository currencyRepository;

    public Currency mapToCurrency(final CurrencyDto currencyDto) throws CurrencyNotFoundException {
        return Currency.builder()
                .id(currencyDto.getId())
                .fromCurrency(currencyDto.getFromCurrency())
                .toCurrency(currencyDto.getToCurrency())
                .rate(currencyDto.getRate())
                .amount(currencyDto.getAmount())
                .convertedAmount(currencyDto.getConvertedAmount())
                .created(currencyDto.getCreated())
                .build();
    }

    public CurrencyDto mapToCurrencyDto(final Currency currency) {
        return CurrencyDto.builder()
                .id(currency.getId())
                .fromCurrency(currency.getFromCurrency())
                .toCurrency(currency.getToCurrency())
                .rate(currency.getRate())
                .amount(currency.getAmount())
                .convertedAmount(currency.getConvertedAmount())
                .created(currency.getCreated())
                .build();
    }

    public List<CurrencyDto> mapToCurrencyDtoList(final List<Currency> currencies) {
        return currencies.stream()
                .map(this::mapToCurrencyDto)
                .collect(Collectors.toList());
    }
}
