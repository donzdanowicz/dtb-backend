package com.dtb.facade;

import com.dtb.domain.EntryAud;
import com.dtb.domain.NetWorth;
import com.dtb.domain.NetWorthAud;
import com.dtb.domain.NetWorthDto;
import com.dtb.exception.NetWorthNotFoundException;
import com.dtb.exception.UserNotFoundException;
import com.dtb.mapper.NetWorthMapper;
import com.dtb.service.NetWorthAudDbService;
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
    @Autowired
    private NetWorthAudDbService netWorthAudDbService;


    public List<NetWorthDto> getNetWorthReport() {
        List<NetWorth> netWorthList = netWorthDbService.getNetWorthReport();
        return netWorthMapper.mapToNetWorthDtoList(netWorthList);
    }

    public NetWorthDto getNetWorthEntry(final Long id) throws NetWorthNotFoundException {
        NetWorth netWorth = netWorthDbService.getNetWorthEntry(id).orElseThrow(NetWorthNotFoundException::new);
        return netWorthMapper.mapToNetWorthDto(netWorth);
    }

    public void deleteNetWorthEntry(final Long id) throws NetWorthNotFoundException {
        NetWorthAud netWorthAud = NetWorthAud.builder()
                .eventDate(LocalDate.now())
                .eventType("DELETE")
                .netWorthId(id)
                .oldRealEstate(getNetWorthEntry(id).getRealEstate())
                .oldCash(getNetWorthEntry(id).getCash())
                .oldVehicles(getNetWorthEntry(id).getVehicles())
                .oldSavingsAndInvestments(getNetWorthEntry(id).getSavingsAndInvestments())
                .oldForeignCurrencies(getNetWorthEntry(id).getForeignCurrencies())
                .oldStocks(getNetWorthEntry(id).getStocks())
                .oldCollections(getNetWorthEntry(id).getCollections())
                .oldHomeContent(getNetWorthEntry(id).getHomeContent())
                .oldOtherAssets(getNetWorthEntry(id).getOtherAssets())
                .oldMortgage(getNetWorthEntry(id).getMortgage())
                .oldLoans(getNetWorthEntry(id).getLoans())
                .oldCreditCards(getNetWorthEntry(id).getCreditCards())
                .oldOtherLiabilities(getNetWorthEntry(id).getOtherLiabilities())
                .oldDate(getNetWorthEntry(id).getDate())
                .oldTotalAssets(getNetWorthEntry(id).getTotalAssets())
                .oldTotalLiabilities(getNetWorthEntry(id).getTotalLiabilities())
                .oldTotalNetWorth(getNetWorthEntry(id).getTotalNetWorth())
                .oldUserId(getNetWorthEntry(id).getUserId())
                .build();

        netWorthAudDbService.saveNetWorthAud(netWorthAud);

        netWorthDbService.deleteNetWorthEntry(id);
    }

    public void createNetWorthEntry(final NetWorthDto netWorthDto) throws UserNotFoundException {
        NetWorth netWorth = netWorthMapper.mapToNetWorth(netWorthDto);
        netWorth.setTotalAssets(netWorth.calculateTotalAssets());
        netWorth.setTotalLiabilities(netWorth.calculateTotalLiabilities());
        netWorth.setTotalNetWorth(netWorth.calculateTotalNetWorth());
        netWorthDbService.saveNetWorthEntry(netWorth);

        NetWorthAud netWorthAud = NetWorthAud.builder()
                .eventDate(LocalDate.now())
                .eventType("INSERT")
                .netWorthId(getNetWorthReport().get(getNetWorthReport().size() - 1).getId())
                .newRealEstate(netWorth.getRealEstate())
                .newCash(netWorth.getCash())
                .newVehicles(netWorth.getVehicles())
                .newSavingsAndInvestments(netWorth.getSavingsAndInvestments())
                .newForeignCurrencies(netWorth.getForeignCurrencies())
                .newStocks(netWorth.getStocks())
                .newCollections(netWorth.getCollections())
                .newHomeContent(netWorth.getHomeContent())
                .newOtherAssets(netWorth.getOtherAssets())
                .newMortgage(netWorth.getMortgage())
                .newLoans(netWorth.getLoans())
                .newCreditCards(netWorth.getCreditCards())
                .newOtherLiabilities(netWorth.getOtherLiabilities())
                .newDate(netWorth.getDate())
                .newTotalAssets(netWorth.getTotalAssets())
                .newTotalLiabilities(netWorth.getTotalLiabilities())
                .newTotalNetWorth(netWorth.getTotalNetWorth())
                .newUserId(netWorthDto.getUserId())
                .build();

        netWorthAudDbService.saveNetWorthAud(netWorthAud);
    }

    public NetWorthDto updateNetWorthEntry(final NetWorthDto netWorthDto) throws UserNotFoundException, NetWorthNotFoundException {
        NetWorth netWorth = netWorthMapper.mapToNetWorth(netWorthDto);

        Long id = netWorthDto.getId();

        NetWorthAud netWorthAud = NetWorthAud.builder()
                .eventDate(LocalDate.now())
                .eventType("UPDATE")
                .netWorthId(netWorthDto.getId())
                .newRealEstate(netWorth.getRealEstate())
                .newCash(netWorth.getCash())
                .newVehicles(netWorth.getVehicles())
                .newSavingsAndInvestments(netWorth.getSavingsAndInvestments())
                .newForeignCurrencies(netWorth.getForeignCurrencies())
                .newStocks(netWorth.getStocks())
                .newCollections(netWorth.getCollections())
                .newHomeContent(netWorth.getHomeContent())
                .newOtherAssets(netWorth.getOtherAssets())
                .newMortgage(netWorth.getMortgage())
                .newLoans(netWorth.getLoans())
                .newCreditCards(netWorth.getCreditCards())
                .newOtherLiabilities(netWorth.getOtherLiabilities())
                .newDate(netWorth.getDate())
                .newTotalAssets(netWorth.getTotalAssets())
                .newTotalLiabilities(netWorth.getTotalLiabilities())
                .newTotalNetWorth(netWorth.getTotalNetWorth())
                .newUserId(netWorthDto.getUserId())
                .oldRealEstate(getNetWorthEntry(id).getRealEstate())
                .oldCash(getNetWorthEntry(id).getCash())
                .oldVehicles(getNetWorthEntry(id).getVehicles())
                .oldSavingsAndInvestments(getNetWorthEntry(id).getSavingsAndInvestments())
                .oldForeignCurrencies(getNetWorthEntry(id).getForeignCurrencies())
                .oldStocks(getNetWorthEntry(id).getStocks())
                .oldCollections(getNetWorthEntry(id).getCollections())
                .oldHomeContent(getNetWorthEntry(id).getHomeContent())
                .oldOtherAssets(getNetWorthEntry(id).getOtherAssets())
                .oldMortgage(getNetWorthEntry(id).getMortgage())
                .oldLoans(getNetWorthEntry(id).getLoans())
                .oldCreditCards(getNetWorthEntry(id).getCreditCards())
                .oldOtherLiabilities(getNetWorthEntry(id).getOtherLiabilities())
                .oldDate(getNetWorthEntry(id).getDate())
                .oldTotalAssets(getNetWorthEntry(id).getTotalAssets())
                .oldTotalLiabilities(getNetWorthEntry(id).getTotalLiabilities())
                .oldTotalNetWorth(getNetWorthEntry(id).getTotalNetWorth())
                .oldUserId(getNetWorthEntry(id).getUserId())
                .build();

        netWorthAudDbService.saveNetWorthAud(netWorthAud);

        NetWorth updatedNetWorth= netWorthDbService.saveNetWorthEntry(netWorth);
        return netWorthMapper.mapToNetWorthDto(updatedNetWorth);
    }

    public List<NetWorthDto> getNetWorthReportByDate(final LocalDate begin, final LocalDate end) {
        List<NetWorth> netWorthListByDate = netWorthDbService.getNetWorthReportByDateBetween(begin, end);
        return netWorthMapper.mapToNetWorthDtoList(netWorthListByDate);
    }

}
