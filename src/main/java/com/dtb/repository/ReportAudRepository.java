package com.dtb.repository;

import com.dtb.domain.ReportAud;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ReportAudRepository extends CrudRepository<ReportAud, Long> {
    @Override
    ReportAud save(ReportAud reportAud);
}
