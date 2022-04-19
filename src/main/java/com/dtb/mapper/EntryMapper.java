package com.dtb.mapper;

import com.dtb.domain.Entry;
import com.dtb.domain.EntryDto;
import com.dtb.exception.UserNotFoundException;
import com.dtb.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EntryMapper {
    private UserRepository userRepository;

    public Entry mapToEntry(final EntryDto entryDto) throws UserNotFoundException {
        return Entry.builder()
                .id(entryDto.getId())
                .income(entryDto.getIncome())
                .food(entryDto.getFood())
                .housing(entryDto.getHousing())
                .transportation(entryDto.getTransportation())
                .healthcare(entryDto.getHealthcare())
                .personal(entryDto.getPersonal())
                .kids(entryDto.getKids())
                .entertainment(entryDto.getEntertainment())
                .miscellaneous(entryDto.getMiscellaneous())
                .travel(entryDto.getTravel())
                .debts(entryDto.getDebts())
                .savingAndInvesting(entryDto.getSavingAndInvesting())
                .type(entryDto.getType())
                .date(entryDto.getDate())
                .user(userRepository.findById(entryDto.getUserId()).orElseThrow(UserNotFoundException::new))
                .build();
    }

    public EntryDto mapToEntryDto(final Entry entry) {
        return EntryDto.builder()
                .id(entry.getId())
                .income(entry.getIncome())
                .food(entry.getFood())
                .housing(entry.getHousing())
                .transportation(entry.getTransportation())
                .healthcare(entry.getHealthcare())
                .personal(entry.getPersonal())
                .kids(entry.getKids())
                .entertainment(entry.getEntertainment())
                .miscellaneous(entry.getMiscellaneous())
                .travel(entry.getTravel())
                .debts(entry.getDebts())
                .savingAndInvesting(entry.getSavingAndInvesting())
                .type(entry.getType())
                .date(entry.getDate())
                .userId(entry.getUser().getId())
                .build();
    }

    public List<EntryDto> mapToEntryDtoList(final List<Entry> entries) {
        return entries.stream()
                .map(this::mapToEntryDto)
                .collect(Collectors.toList());
    }
}
