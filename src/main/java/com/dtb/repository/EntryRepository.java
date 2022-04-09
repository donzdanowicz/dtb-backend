package com.dtb.repository;

import com.dtb.domain.Entry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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
}
