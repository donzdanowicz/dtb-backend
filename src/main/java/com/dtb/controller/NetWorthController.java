package com.dtb.controller;

import com.dtb.domain.NetWorth;
import com.dtb.domain.NetWorthDto;
import com.dtb.exception.NetWorthNotFoundException;
import com.dtb.exception.UserNotFoundException;
import com.dtb.facade.NetWorthFacade;
import com.dtb.mapper.NetWorthMapper;
import com.dtb.service.NetWorthDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
public class NetWorthController {
    private final NetWorthFacade netWorthFacade;

    @GetMapping(value = "/netWorth")
    public List<NetWorthDto> getNetWorthReport() {
        return netWorthFacade.getNetWorthReport();
    }

    @GetMapping(value = "/netWorth/{id}")
    public NetWorthDto getNetWorthEntry(@PathVariable Long id) throws NetWorthNotFoundException {
        return netWorthFacade.getNetWorthEntry(id);
    }

    @DeleteMapping(value = "/netWorth/{id}")
    public void deleteNetWorthEntry(@PathVariable Long id) throws NetWorthNotFoundException {
//        netWorthDbService.deleteNetWorthEntry(id);
        netWorthFacade.deleteNetWorthEntry(id);
    }

    @PostMapping(value = "/netWorth", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNetWorthEntry(@RequestBody NetWorthDto netWorthDto) throws UserNotFoundException {
        netWorthFacade.createNetWorthEntry(netWorthDto);
    }

    @PutMapping(value = "/netWorth")
    public NetWorthDto updateNetWorthEntry(@RequestBody NetWorthDto netWorthDto)
            throws UserNotFoundException, NetWorthNotFoundException {
        return netWorthFacade.updateNetWorthEntry(netWorthDto);
    }

    @GetMapping(value = "/netWorth/date")
    public List<NetWorthDto> getNetWorthReportByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                      LocalDate begin, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return netWorthFacade.getNetWorthReportByDate(begin, end);
    }

}
