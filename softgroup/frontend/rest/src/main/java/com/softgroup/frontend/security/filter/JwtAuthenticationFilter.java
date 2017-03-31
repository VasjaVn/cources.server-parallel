package com.softgroup.frontend.security.filter;

import com.softgroup.frontend.security.JwtAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("jwtAuthenticationFilter")
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final String REQUEST_HEADER_X_TOKEN = "X-Token";

    @Autowired
    private AuthenticationManager jwtAuthenticationManager;

    @Autowired
    private AuthenticationSuccessHandler jwtAuthenticationSuccessHandler;

    @PostConstruct
    public void init() {
        setAuthenticationManager(jwtAuthenticationManager);
        setAuthenticationSuccessHandler(jwtAuthenticationSuccessHandler);
    }

    public JwtAuthenticationFilter() {
        super("/api/private");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("-=[ attemptAuthentication ]=-");

        String valueHeaderXToken = request.getHeader( REQUEST_HEADER_X_TOKEN );
        JwtAuthentication jwtAuthentication = new JwtAuthentication( valueHeaderXToken );

        return getAuthenticationManager().authenticate( jwtAuthentication );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        System.out.println("-=[ successfulAuthentication ]=-");
        chain.doFilter(request, response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
        System.out.println("-=[ unsuccessfulAuthentication ]=-");
    }
}