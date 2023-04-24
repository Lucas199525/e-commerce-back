package com.ArcomTech.ApiV1.service;

import com.ArcomTech.ApiV1.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    User saveUser(User user);

    User getUserById(Long id);
    List<User> fetchAllUser();
    User updateUserById(Long id, User user);

    String deleteUserById(Long id);
}
