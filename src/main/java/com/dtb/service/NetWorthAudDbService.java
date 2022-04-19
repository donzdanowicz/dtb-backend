package com.dtb.service;

import com.dtb.domain.EntryAud;
import com.dtb.domain.NetWorthAud;
import com.dtb.repository.NetWorthAudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NetWorthAudDbService {
    private final NetWorthAudRepository netWorthAudRepository;

    public NetWorthAud saveNetWorthAud(final NetWorthAud netWorthAud) {
        return netWorthAudRepository.save(netWorthAud);
    }
}
