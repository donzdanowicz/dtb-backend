package com.dtb.service;

import com.dtb.domain.NetWorth;
import com.dtb.repository.NetWorthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NetWorthDbService {
    private final NetWorthRepository netWorthRepository;

    public List<NetWorth> getNetWorthReport() {
        return netWorthRepository.findAll();
    }

    public Optional<NetWorth> getNetWorthEntry(final Long id) {
        return netWorthRepository.findById(id);
    }

    public NetWorth saveNetWorthEntry(final NetWorth netWorth) {
        return netWorthRepository.save(netWorth);
    }

    public void deleteNetWorthEntry(final Long id) {
        netWorthRepository.deleteById(id);
    }
}
