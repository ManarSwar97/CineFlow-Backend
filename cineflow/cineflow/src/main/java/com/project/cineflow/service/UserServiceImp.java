package com.project.cineflow.service;

import com.project.cineflow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp {

    private final UserRepository userRepository;

    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {


            public UserDetails loadUserByUsername (String username){

                return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));

            }
        };
    }


}
