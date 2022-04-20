package com.dtb.service;

import com.dtb.domain.StockPriceAud;
import com.dtb.repository.StockPriceAudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StockPriceAudDbService {
    private final StockPriceAudRepository stockPriceAudRepository;

    public StockPriceAud saveStockPriceAud(final StockPriceAud stockPriceAud) {
        return stockPriceAudRepository.save(stockPriceAud);
    }
}
