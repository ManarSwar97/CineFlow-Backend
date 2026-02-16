package com.project.cineflow.service;

import com.project.cineflow.dto.JwtAuthenticationResponse;
import com.project.cineflow.dto.RefreshTokenRequest;
import com.project.cineflow.dto.SignInRequest;
import com.project.cineflow.dto.SignUpRequest;
import com.project.cineflow.entity.User;
import com.project.cineflow.enums.UserRole;
import com.project.cineflow.interfaces.JWTService;
import com.project.cineflow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImp implements AuthenticationService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public User signup(SignUpRequest signUpRequest){
        User user = new User();
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setEmail(signUpRequest.getEmail());
        user.setRole(UserRole.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(user);
    }

    public JwtAuthenticationResponse signin(SignInRequest sign){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(sign.getEmail(), sign.getPassword()));
        var user = userRepository.findByEmail(sign.getEmail()).orElseThrow(()->new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);

        return jwtAuthenticationResponse;

    }


    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest request){

        System.out.println("REFRESH TOKEN RECEIVED: " + request.getToken());

        String token = request.getToken();

        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        String userEmail = jwtService.extractUsername(token);

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(jwtService.isValidToken(token, user)){

            var newAccessToken = jwtService.generateToken(user);

            JwtAuthenticationResponse response = new JwtAuthenticationResponse();
            response.setToken(newAccessToken);
            response.setRefreshToken(token);

            return response;
        }

        throw new RuntimeException("Invalid refresh token");
    }

}
