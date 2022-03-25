package com.dtb.repository;

import com.dtb.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    @Override
    List<Category> findAll();

    @Override
    Category save(Category category);

    @Override
    void deleteById(Long id);

    @Override
    Optional<Category> findById(Long id);

    Optional<Category> findByName(String categoryName);
}
