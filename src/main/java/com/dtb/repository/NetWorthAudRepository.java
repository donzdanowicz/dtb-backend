package com.dtb.repository;

import com.dtb.domain.EntryAud;
import com.dtb.domain.NetWorth;
import com.dtb.domain.NetWorthAud;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface NetWorthAudRepository extends CrudRepository<NetWorthAud, Long> {
    @Override
    NetWorthAud save(NetWorthAud netWorthAud);
}
