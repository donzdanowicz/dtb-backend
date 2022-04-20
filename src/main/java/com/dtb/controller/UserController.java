package com.dtb.controller;

import com.dtb.domain.User;
import com.dtb.domain.UserDto;
import com.dtb.exception.UserNotFoundException;
import com.dtb.facade.UserFacade;
import com.dtb.mapper.UserMapper;
import com.dtb.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
public class UserController {
    private final UserFacade userFacade;

    @GetMapping(value = "/users")
    public List<UserDto> getUsers() {
        return userFacade.getUsers();
    }

    @GetMapping(value = "/users/{id}")
    public UserDto getUser(@PathVariable Long id) throws UserNotFoundException {
        return userFacade.getUser(id);
    }

    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable Long id) throws UserNotFoundException {
        userFacade.deleteUser(id);
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {

        userFacade.createUser(userDto);
    }

    @PutMapping(value = "/users")
    public UserDto updateUser(@RequestBody UserDto userDto) throws UserNotFoundException {

        return userFacade.updateUser(userDto);
    }

}
