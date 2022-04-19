package com.dtb.repository;

import com.dtb.domain.Currency;
import com.dtb.domain.Entry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Long> {
    @Override
    List<Currency> findAll();

    @Override
    Currency save(Currency currency);

    @Override
    void deleteById(Long id);

    @Override
    Optional<Currency> findById(Long id);

    @Query(nativeQuery = true)
    List<Currency> getLatest10();
}
