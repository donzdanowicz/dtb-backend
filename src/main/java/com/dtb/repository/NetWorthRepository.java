package com.dtb.repository;

import com.dtb.domain.NetWorth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface NetWorthRepository extends CrudRepository<NetWorth, Long> {
    @Override
    List<NetWorth> findAll();

    @Override
    NetWorth save(NetWorth netWorth);

    @Override
    void deleteById(Long id);

    @Override
    Optional<NetWorth> findById(Long id);

    List<NetWorth> getNetWorthsByDateBetween(LocalDate begin, LocalDate end);
}
