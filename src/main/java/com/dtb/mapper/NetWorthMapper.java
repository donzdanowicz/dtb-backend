package com.dtb.mapper;

import com.dtb.domain.NetWorth;
import com.dtb.domain.NetWorthDto;
import com.dtb.exception.UserNotFoundException;
import com.dtb.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class NetWorthMapper {
    private UserRepository userRepository;

    public NetWorth mapToNetWorth(final NetWorthDto netWorthDto) throws UserNotFoundException {
        NetWorth netWorth = new NetWorth.NetWorthBuilder()
                .id(netWorthDto.getId())
                .realEstate(netWorthDto.getRealEstate())
                .cash(netWorthDto.getCash())
                .vehicles(netWorthDto.getVehicles())
                .savingsAndInvestments(netWorthDto.getSavingsAndInvestments())
                .foreignCurrencies(netWorthDto.getForeignCurrencies())
                .stocks(netWorthDto.getStocks())
                .collections(netWorthDto.getCollections())
                .homeContent(netWorthDto.getHomeContent())
                .otherAssets(netWorthDto.getOtherAssets())
                .mortgage(netWorthDto.getMortgage())
                .loans(netWorthDto.getLoans())
                .creditCards(netWorthDto.getCreditCards())
                .otherLiabilities(netWorthDto.getOtherLiabilities())
                .date(netWorthDto.getDate())
                .user(userRepository.findById(netWorthDto.getUserId()).orElseThrow(UserNotFoundException::new))
                .build();

        netWorth.setTotalAssets(netWorth.calculateTotalAssets());
        netWorth.setTotalLiabilities(netWorth.calculateTotalLiabilities());
        netWorth.setTotalNetWorth(netWorth.calculateTotalNetWorth());

        return netWorth;
    }

    public NetWorthDto mapToNetWorthDto(final NetWorth netWorth) {
        NetWorthDto netWorthDto = new NetWorthDto.NetWorthDtoBuilder()
                .id(netWorth.getId())
                .realEstate(netWorth.getRealEstate())
                .cash(netWorth.getCash())
                .vehicles(netWorth.getVehicles())
                .savingsAndInvestments(netWorth.getSavingsAndInvestments())
                .foreignCurrencies(netWorth.getForeignCurrencies())
                .stocks(netWorth.getStocks())
                .collections(netWorth.getCollections())
                .homeContent(netWorth.getHomeContent())
                .otherAssets(netWorth.getOtherAssets())
                .mortgage(netWorth.getMortgage())
                .loans(netWorth.getLoans())
                .creditCards(netWorth.getCreditCards())
                .otherLiabilities(netWorth.getOtherLiabilities())
                .date(netWorth.getDate())
                .userId(netWorth.getUser().getId())
                .build();

        netWorthDto.setTotalAssets(netWorthDto.calculateTotalAssets());
        netWorthDto.setTotalLiabilities(netWorthDto.calculateTotalLiabilities());
        netWorthDto.setTotalNetWorth(netWorthDto.calculateTotalNetWorth());

        return netWorthDto;
    }

    public List<NetWorthDto> mapToNetWorthDtoList(final List<NetWorth> netWorthList) {
        return netWorthList.stream()
                .map(this::mapToNetWorthDto)
                .collect(Collectors.toList());
    }

}