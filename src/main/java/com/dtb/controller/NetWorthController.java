package com.dtb.controller;

import com.dtb.domain.NetWorth;
import com.dtb.domain.NetWorthDto;
import com.dtb.exception.NetWorthNotFoundException;
import com.dtb.exception.UserNotFoundException;
import com.dtb.mapper.NetWorthMapper;
import com.dtb.service.NetWorthDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
public class NetWorthController {
    private final NetWorthDbService netWorthDbService;
    private final NetWorthMapper netWorthMapper;

    @GetMapping(value = "/netWorth")
    public List<NetWorthDto> getNetWorthReport() {
        List<NetWorth> netWorthList = netWorthDbService.getNetWorthReport();
        return netWorthMapper.mapToNetWorthDtoList(netWorthList);
    }

    @GetMapping(value = "/netWorth/{id}")
    public NetWorthDto getNetWorthEntry(@PathVariable Long id) throws NetWorthNotFoundException {
        return netWorthMapper.mapToNetWorthDto(
                netWorthDbService.getNetWorthEntry(id).orElseThrow(NetWorthNotFoundException::new)
        );
    }

    @DeleteMapping(value = "/netWorth/{id}")
    public void deleteNetWorthEntry(@PathVariable Long id) {
        netWorthDbService.deleteNetWorthEntry(id);
    }

    @PostMapping(value = "/netWorth", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNetWorthEntry(@RequestBody NetWorthDto netWorthDto) throws UserNotFoundException {
        NetWorth netWorth = netWorthMapper.mapToNetWorth(netWorthDto);
        netWorth.setTotalAssets(netWorth.calculateTotalAssets());
        netWorth.setTotalLiabilities(netWorth.calculateTotalLiabilities());
        netWorth.setTotalNetWorth(netWorth.calculateTotalNetWorth());
        netWorthDbService.saveNetWorthEntry(netWorth);
    }

    @PutMapping(value = "/netWorth")
    public NetWorthDto updateNetWorthEntry(@RequestBody NetWorthDto netWorthDto) throws UserNotFoundException {
        NetWorth netWorth = netWorthMapper.mapToNetWorth(netWorthDto);
        NetWorth updatedNetWorth= netWorthDbService.saveNetWorthEntry(netWorth);
        return netWorthMapper.mapToNetWorthDto(updatedNetWorth);
    }
}
