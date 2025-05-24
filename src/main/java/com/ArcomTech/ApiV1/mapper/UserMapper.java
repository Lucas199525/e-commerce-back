package com.ArcomTech.ApiV1.mapper;

import com.ArcomTech.ApiV1.model.User;
import com.ArcomTech.ApiV1.dto.UserCreationDto;
import com.ArcomTech.ApiV1.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends AbstractMapper<User, UserCreationDto, UserDto> {
}
