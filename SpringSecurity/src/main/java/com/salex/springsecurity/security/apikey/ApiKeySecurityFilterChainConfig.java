package com.salex.springsecurity.security.apikey;

import com.salex.springsecurity.security.apikey.filter.ApiKeyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ApiKeySecurityFilterChainConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf
                .disable()
            )
            .addFilterBefore(new ApiKeyFilter(), BasicAuthenticationFilter.class)
            .authorizeHttpRequests(requests -> requests
                    .requestMatchers("/stranger").permitAll()
                    .requestMatchers("/user").authenticated()
            );

        return http.build();
    }

}
