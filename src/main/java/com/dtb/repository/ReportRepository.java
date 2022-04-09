package com.dtb.repository;

import com.dtb.domain.Report;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {

   /* @Override
    List<Report> findAll();

    @Override
    Report save(Report report);

    @Override
    void deleteById(Long id);

    @Override
    Optional<Report> findById(Long id);*/

    @Query
    List<Report> report();
}
