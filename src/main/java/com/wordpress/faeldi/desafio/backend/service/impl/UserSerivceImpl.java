package com.wordpress.faeldi.desafio.backend.service.impl;

import com.wordpress.faeldi.desafio.backend.dto.UserDto;
import com.wordpress.faeldi.desafio.backend.models.User;
import com.wordpress.faeldi.desafio.backend.repository.UserRepository;
import com.wordpress.faeldi.desafio.backend.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserSerivceImpl implements BaseService<UserDto, User> {

    private final UserRepository userRepository;

    public UserSerivceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto create(User obj) {
        return null;
    }

    @Override
    public UserDto findById(Long id) {
        return null;
    }

    @Override
    public List<UserDto> findAll() {
         return userRepository.findAll().stream()
                 .map(user -> new UserDto(
                         user.getFullName(),
                         user.getEmail(),
                         user.getAccountBalance(),
                         user.getType()))
                 .collect(Collectors.toList());
    }

    @Override
    public UserDto edit(User obj) {
        return null;
    }
}
