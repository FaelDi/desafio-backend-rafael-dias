package com.wordpress.faeldi.desafio.backend.controller;

import com.wordpress.faeldi.desafio.backend.dto.UserDto;
import com.wordpress.faeldi.desafio.backend.models.User;
import com.wordpress.faeldi.desafio.backend.service.BaseController;
import com.wordpress.faeldi.desafio.backend.service.impl.UserSerivceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<UserDto, User, UserSerivceImpl> {
    public UserController(UserSerivceImpl service) {
        super(service);
    }
}
