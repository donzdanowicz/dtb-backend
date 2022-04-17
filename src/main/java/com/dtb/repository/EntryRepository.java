package com.dtb.repository;

import com.dtb.domain.Entry;
import com.dtb.domain.EntryType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface EntryRepository extends CrudRepository<Entry, Long> {
    @Override
    List<Entry> findAll();

    @Override
    Entry save(Entry entry);

    @Override
    void deleteById(Long id);

    @Override
    Optional<Entry> findById(Long id);

    @Query(nativeQuery = true)
    List<Entry> report();

    List<Entry> getEntriesByType(EntryType type);

    List<Entry> getEntriesByDateBetween(LocalDate begin, LocalDate end);

    @Query(nativeQuery = true)
    List<Entry> reportByDate(@Param("BEGIN") LocalDate begin, @Param("END") LocalDate end);


}
