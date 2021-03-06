package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime created;
    private String currency;
    private boolean active;


}
