package com.dtb.scheduler;

import com.dtb.client.CurrencyConverterClient;
import com.dtb.controller.CurrencyConverterController;
import com.dtb.exception.CurrencyNotFoundException;
import com.dtb.facade.CurrencyFacade;
import com.dtb.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CurrencyScheduler {
    private final CurrencyConverterController currencyConverterController;

    @Scheduled(cron = "0 0 10,15 * * *")
    //@Scheduled(fixedDelay = 20000)
    public void checkUSDCADRate() throws CurrencyNotFoundException {
        currencyConverterController.getConvertedAmount("USD", "CAD", Optional.of(1.0));
    }

    @Scheduled(cron = "0 0 10,15 * * *")
    public void checkUSDEURRate() throws CurrencyNotFoundException {
        currencyConverterController.getConvertedAmount("USD", "EUR", Optional.of(1.0));
    }

    @Scheduled(cron = "0 0 10,15 * * *")
    public void checkUSDPLNRate() throws CurrencyNotFoundException {
        currencyConverterController.getConvertedAmount("USD", "PLN", Optional.of(1.0));
    }


}
