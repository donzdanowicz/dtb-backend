package com.dtb.service;

import com.dtb.domain.ReportAud;
import com.dtb.domain.StockPriceAud;
import com.dtb.repository.ReportAudRepository;
import com.dtb.repository.StockPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StockPriceAudDbService {
    private final StockPriceRepository stockPriceRepository;

    public StockPriceAud saveStockPriceAud(final StockPriceAud stockPriceAud) {
        return stockPriceRepository.save(stockPriceAud);
    }
}
