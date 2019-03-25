package com.tomtre.shoppinglist.web.service;

import com.tomtre.shoppinglist.web.dto.CustomSecurityUser;
import com.tomtre.shoppinglist.web.dto.UserDto;
import com.tomtre.shoppinglist.web.exception.UserAlreadyExistsException;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    UserDto findByUsername(CustomSecurityUser customSecurityUser, String username);

    UserDto findById(CustomSecurityUser customSecurityUser, long userId);

    UserDto save(UserDto userDto) throws UserAlreadyExistsException;

    void update(CustomSecurityUser customSecurityUser, UserDto userDto);

    void remove(CustomSecurityUser customSecurityUser, String username);
}
