package com.dtb.facade;

import com.dtb.domain.NetWorth;
import com.dtb.domain.NetWorthDto;
import com.dtb.exception.NetWorthNotFoundException;
import com.dtb.exception.UserNotFoundException;
import com.dtb.mapper.NetWorthMapper;
import com.dtb.service.NetWorthDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Component
public class NetWorthFacade {
    @Autowired
    private NetWorthDbService netWorthDbService;
    @Autowired
    private NetWorthMapper netWorthMapper;

    public List<NetWorthDto> getNetWorthReport() {
        List<NetWorth> netWorthList = netWorthDbService.getNetWorthReport();
        return netWorthMapper.mapToNetWorthDtoList(netWorthList);
    }

    public NetWorthDto getNetWorthEntry(final Long id) throws NetWorthNotFoundException {
        NetWorth netWorth = netWorthDbService.getNetWorthEntry(id).orElseThrow(NetWorthNotFoundException::new);
        return netWorthMapper.mapToNetWorthDto(netWorth);
    }

    public void deleteNetWorthEntry(final Long id) {
        netWorthDbService.deleteNetWorthEntry(id);
    }

    public void createNetWorthEntry(final NetWorthDto netWorthDto) throws UserNotFoundException {
        NetWorth netWorth = netWorthMapper.mapToNetWorth(netWorthDto);
        netWorth.setTotalAssets(netWorth.calculateTotalAssets());
        netWorth.setTotalLiabilities(netWorth.calculateTotalLiabilities());
        netWorth.setTotalNetWorth(netWorth.calculateTotalNetWorth());
        netWorthDbService.saveNetWorthEntry(netWorth);
    }

    public NetWorthDto updateNetWorthEntry(final NetWorthDto netWorthDto) throws UserNotFoundException {
        NetWorth netWorth = netWorthMapper.mapToNetWorth(netWorthDto);
        NetWorth updatedNetWorth= netWorthDbService.saveNetWorthEntry(netWorth);
        return netWorthMapper.mapToNetWorthDto(updatedNetWorth);
    }

    public List<NetWorthDto> getNetWorthReportByDate(final LocalDate begin, final LocalDate end) {
        List<NetWorth> netWorthListByDate = netWorthDbService.getNetWorthReportByDateBetween(begin, end);
        return netWorthMapper.mapToNetWorthDtoList(netWorthListByDate);
    }

}
