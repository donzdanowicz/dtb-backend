package com.dtb.repository;

import com.dtb.domain.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface PlanRepository extends CrudRepository<Plan, Long> {

    @Override
    List<Plan> findAll();

    @Override
    Plan save(Plan plan);

    @Override
    void deleteById(Long id);

    @Override
    Optional<Plan> findById(Long id);
}
