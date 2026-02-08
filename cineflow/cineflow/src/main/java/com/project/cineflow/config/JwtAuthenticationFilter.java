package com.project.cineflow.config;

import ch.qos.logback.core.util.StringUtil;
import com.project.cineflow.interfaces.JWTService;
import com.project.cineflow.service.JWTServiceImp;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private final JWTService jwtService;
    private final UserService userService;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //get the authorization from the header
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String username;
        //check if header is empty or not or not start with bearer
        if(StringUtils.isEmpty(authHeader) || !org.apache.commons.lang3.StringUtils.startsWith(authHeader, "Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        jwt = authHeader.substring(7);

        username = jwtService.extractUsername(jwt);

        if(StringUtils.isNotEmpty(username) && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userService.userDetailsService().loadUserByUsername(username);
        }

    }
}
