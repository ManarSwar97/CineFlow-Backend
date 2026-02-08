package com.project.cineflow.interfaces;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {

    String generateToken(UserDetails userDetails);
    String extractUsername(String token);
}
