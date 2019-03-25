package com.tomtre.shoppinglist.web.restcontroller;

import com.tomtre.shoppinglist.web.config.RestServiceDescriptor;
import com.tomtre.shoppinglist.web.dto.CustomSecurityUser;
import com.tomtre.shoppinglist.web.dto.UserDto;
import com.tomtre.shoppinglist.web.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestServiceDescriptor.FULL_PATH)
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{username}")
    public UserDto getUser(@AuthenticationPrincipal CustomSecurityUser customSecurityUser, @PathVariable String username) {
        return userService.findByUsername(customSecurityUser, username);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @PutMapping("/users")
    public UserDto updateUser(@AuthenticationPrincipal CustomSecurityUser customSecurityUser, @RequestBody UserDto userDto) {
        userService.update(customSecurityUser, userDto);
        return userDto;
    }

    @DeleteMapping("/users/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@AuthenticationPrincipal CustomSecurityUser customSecurityUser, @PathVariable String username) {
        userService.remove(customSecurityUser, username);
    }


}
