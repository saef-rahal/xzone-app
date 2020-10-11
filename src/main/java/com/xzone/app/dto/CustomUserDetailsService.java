package com.xzone.app.dto;

import com.xzone.app.model.User;
import com.xzone.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Saef Rahal on 9/30/2020.
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByEmailOrUsername(usernameOrEmail, usernameOrEmail).orElseThrow(() -> new UsernameNotFoundException("User Not Found With Email Or Username"+usernameOrEmail));
        return UserPrinciple.create(user);
    }

    // use by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User Not Found With ID: "+id));
        return UserPrinciple.create(user);
    }
}
