package com.ArcomTech.ApiV1.controller;

import com.ArcomTech.ApiV1.model.User;
import com.ArcomTech.ApiV1.service.UserService;
import com.ArcomTech.ApiV1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id){
        try {
            User user = userService.get(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return  new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("user/name:/{name}")
    public List<User> getByName(@PathVariable String name){ return userService.listAll() /*userRepository.findByName(name)*/;}

    @GetMapping("user/")
    public List<User> list(){return userService.listAll();}

    @PostMapping("user/add")
    public void add(@RequestBody User newuser){userService.save(newuser);}
    @PutMapping("user/update/{id}")
    public ResponseEntity<?> update(@RequestBody User user,@PathVariable Integer id){
        try {
            User existUser = userService.get(id);
            userService.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NoSuchElementException e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("user/delete/{id}")
    public void delete(@PathVariable Integer id){userService.delete(id);}
}
