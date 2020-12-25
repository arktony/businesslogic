package com.enclave.businesslogic.filters;

import com.enclave.businesslogic.service.UserDetailsServiceImpl;
import com.enclave.businesslogic.service.UserService;
import com.enclave.businesslogic.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        final String authorizationheader = httpServletRequest.getHeader("Authorization");

        String username = null;
        String jwt = null;

        if (authorizationheader != null && authorizationheader.startsWith("Bearer ")){
            jwt = authorizationheader.substring(7);
            username = jwtTokenUtil.extractUsername(jwt);
        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){

            UserDetails userDetails = this.userDetailService.loadUserByUsername(username);
            if (jwtTokenUtil.validateToken(jwt,userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToke;
                usernamePasswordAuthenticationToke = new UsernamePasswordAuthenticationToken(
                        userDetails,null,userDetails.getAuthorities());

                usernamePasswordAuthenticationToke
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToke);
            }

        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
