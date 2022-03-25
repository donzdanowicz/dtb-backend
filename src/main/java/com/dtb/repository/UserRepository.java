package com.dtb.repository;

import com.dtb.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    List<User> findAll();

    @Override
    User save(User user);

    @Override
    void deleteById(Long id);

    @Override
    Optional<User> findById(Long id);
}
