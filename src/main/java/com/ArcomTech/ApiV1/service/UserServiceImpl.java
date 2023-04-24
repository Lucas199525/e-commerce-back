package com.ArcomTech.ApiV1.service;

import com.ArcomTech.ApiV1.model.User;
import com.ArcomTech.ApiV1.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private static UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User>  user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }


        return null;
    }

    @Override
    public List<User> fetchAllUser() {
        List<User> allUsers = userRepository.findAll();
        return null;
    }

    @Override
    public User updateUserById(Long id, User user) {
        return null;
    }

    @Override
    public String deleteUserById(Long id) {
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return "User Delete";
        }
        return "No such user";
    }
}
