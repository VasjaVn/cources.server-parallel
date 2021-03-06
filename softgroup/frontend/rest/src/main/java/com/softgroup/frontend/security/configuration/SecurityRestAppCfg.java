package com.softgroup.frontend.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;

@Configuration
@EnableWebSecurity
@ComponentScan("com.softgroup.frontend.security")
public class SecurityRestAppCfg extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    @Qualifier("jwtAuthenticationFilter")
    private Filter jwtAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http
                .exceptionHandling().authenticationEntryPoint( jwtAuthenticationEntryPoint )
                .and()
                .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS )
                .and()
                .csrf().disable()
                .antMatcher("/api/**")
                .authorizeRequests()
                .antMatchers("/api/private").authenticated()
                .antMatchers("/api/**").permitAll()
                .and()
                .addFilterBefore( jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class );
    }

}
