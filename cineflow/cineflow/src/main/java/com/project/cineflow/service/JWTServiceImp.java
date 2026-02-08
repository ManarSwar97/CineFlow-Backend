package com.project.cineflow.service;
import com.project.cineflow.interfaces.JWTService;
import com.project.cineflow.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

@Service
@AllArgsConstructor
public class JWTServiceImp implements JWTService {

    private final UserRepository userRepository;

    @Value("${jwt.secret}")
    private String jwtsecret;
    private String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignKey(), SignatureAlgorithm.ES256)
                .compact();
    }


    //get particular claim
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers){
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    private Key getSignKey() {
        byte[] keyBytes = Base64.getDecoder().decode(jwtsecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //get all the claims from the token
    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(jwtsecret).getBody();
    }

    public String extractUsername(String token){
        //get username
        return extractClaim(token, Claims::getSubject);

    }


}
