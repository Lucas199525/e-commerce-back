package com.ArcomTech.ApiV1.controller;


import com.ArcomTech.ApiV1.service.UserService;
import com.ArcomTech.ApiV1.dto.UserCreationDto;
import com.ArcomTech.ApiV1.dto.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<Integer, UserCreationDto, UserDto> {

    protected UserController(UserService userService) {
        super(userService);
    }
}
