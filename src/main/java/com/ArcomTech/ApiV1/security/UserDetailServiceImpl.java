package com.ArcomTech.ApiV1.security;

import com.ArcomTech.ApiV1.model.User;
import com.ArcomTech.ApiV1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        User user = userRepository
                .findOneByMail(mail)
                .orElseThrow(()-> new UsernameNotFoundException("Utilisateur non trouvé"));
       return new UserDetailsImpl(user);
    }
}
