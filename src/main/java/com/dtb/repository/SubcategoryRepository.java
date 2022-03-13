package com.dtb.repository;

import com.dtb.domain.Subcategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface SubcategoryRepository extends CrudRepository<Subcategory, Long> {
    @Override
    List<Subcategory> findAll();

    @Override
    Subcategory save(Subcategory subcategory);

    @Override
    void deleteById(Long id);

    @Override
    Optional<Subcategory> findById(Long id);
}
