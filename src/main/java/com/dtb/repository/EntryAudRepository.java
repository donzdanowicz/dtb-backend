package com.dtb.repository;

import com.dtb.domain.Entry;
import com.dtb.domain.EntryAud;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface EntryAudRepository extends CrudRepository<EntryAud, Long> {
    @Override
    EntryAud save(EntryAud entryAud);
}
