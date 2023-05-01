package com.ArcomTech.ApiV1.service;

import com.ArcomTech.ApiV1.model.User;
import com.ArcomTech.ApiV1.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAll(){return userRepository.findAll();}

    public User get(Integer id){ return userRepository.findById(id).get();}

    public void  save(User user){userRepository.save(user);}

    public void delete(Integer id){userRepository.deleteById(id);}
}
