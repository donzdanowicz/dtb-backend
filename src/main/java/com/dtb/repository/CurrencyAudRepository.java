package com.dtb.repository;

import com.dtb.domain.CurrencyAud;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CurrencyAudRepository extends CrudRepository<CurrencyAud, Long> {
    @Override
    CurrencyAud save(CurrencyAud currencyAud);
}
