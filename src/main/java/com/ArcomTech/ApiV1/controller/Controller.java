package com.ArcomTech.ApiV1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {


    private final RestTemplate restTemplate;

    @Autowired
    public Controller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/h")
    public String hello()
    {
        return "Hello Arcom";
    }

    @GetMapping("/date")
    public String  date(){
        return "12/02/1995";
    }

    @GetMapping("/poke")
    public Object getPoke(){
        String url = "https://pokeapi.co/api/v2/pokemon/ditto";
        return restTemplate.getForObject(url, Object.class);
    }
}
