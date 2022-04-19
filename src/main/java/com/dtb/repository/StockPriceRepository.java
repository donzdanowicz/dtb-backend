package com.dtb.repository;

import com.dtb.domain.StockPriceAud;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface StockPriceRepository extends CrudRepository<StockPriceAud, Long> {
    @Override
    StockPriceAud save(StockPriceAud stockPriceAud);
}
