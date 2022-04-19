package com.dtb.repository;

import com.dtb.domain.UserAud;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserAudRepository extends CrudRepository<UserAud, Long> {
    @Override
    UserAud save(UserAud userAud);
}
