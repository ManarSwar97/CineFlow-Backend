package com.project.cineflow.service;

import com.project.cineflow.dto.JwtAuthenticationResponse;
import com.project.cineflow.dto.SignInRequest;
import com.project.cineflow.dto.SignUpRequest;
import com.project.cineflow.entity.User;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SignInRequest sign);
}
