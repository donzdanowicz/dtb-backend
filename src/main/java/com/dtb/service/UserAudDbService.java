package com.dtb.service;

import com.dtb.domain.EntryAud;
import com.dtb.domain.UserAud;
import com.dtb.repository.EntryAudRepository;
import com.dtb.repository.UserAudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserAudDbService {
    private final UserAudRepository userAudRepository;

    public UserAud saveUserAud(final UserAud userAud) {
        return userAudRepository.save(userAud);
    }
}
