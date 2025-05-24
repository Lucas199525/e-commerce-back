package com.ArcomTech.ApiV1;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class userTest {
    @Test
    public void generatePasswod(){
        BCryptPasswordEncoder passGen = new BCryptPasswordEncoder();
        System.out.println(passGen.encode("17021995admin"));
    }
}
