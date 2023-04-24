package com.ArcomTech.ApiV1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @GetMapping("/h")
    public String hello()
    {
        return "Hello Arcom";
    }

    @GetMapping("/date")
    public String  date(){
        return "12/02/1995";
    }
}
