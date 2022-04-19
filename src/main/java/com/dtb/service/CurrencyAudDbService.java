package com.dtb.service;

import com.dtb.domain.CurrencyAud;
import com.dtb.domain.EntryAud;
import com.dtb.repository.CurrencyAudRepository;
import com.dtb.repository.EntryAudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CurrencyAudDbService {
    private final CurrencyAudRepository currencyAudRepository;

    public CurrencyAud saveCurrencyAud(final CurrencyAud currencyAud) {
        return currencyAudRepository.save(currencyAud);
    }

}
