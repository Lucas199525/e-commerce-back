package com.ArcomTech.ApiV1.service;

import com.ArcomTech.ApiV1.model.User;
import com.ArcomTech.ApiV1.repository.UserRepository;
import com.ArcomTech.ApiV1.dto.UserCreationDto;
import com.ArcomTech.ApiV1.dto.UserDto;
import com.ArcomTech.ApiV1.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractEntityService<User, Integer, UserRepository, UserCreationDto, UserDto, UserMapper> {

    public UserService(UserRepository repository, UserMapper userMapper) {
        super(repository, userMapper, "User");
    }
}
