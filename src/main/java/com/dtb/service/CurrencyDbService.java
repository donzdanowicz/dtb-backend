package com.dtb.service;

import com.dtb.domain.Currency;
import com.dtb.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CurrencyDbService {
    private final CurrencyRepository currencyRepository;

    public List<Currency> getCurrencies() {
        return currencyRepository.findAll();
    }

    public Optional<Currency> getCurrency(final Long id) {
        return currencyRepository.findById(id);
    }

    public Currency saveCurrency(final Currency currency) {
        return currencyRepository.save(currency);
    }

    public void deleteCurrency(final Long id) {
        currencyRepository.deleteById(id);
    }

    public List<Currency> getLatest10() {
        return currencyRepository.getLatest10();
    }
}
