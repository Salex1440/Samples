package com.salex.springsecurity.security.apikey;

import com.salex.springsecurity.security.apikey.filter.ApiKeyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ApiKeySecurityFilterChainConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ApiKeyUserDetailsService apiKeyUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf
                .disable()
            )
            .addFilterBefore(new ApiKeyFilter(authenticationManager()), BasicAuthenticationFilter.class)
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/stranger").permitAll()
                .requestMatchers("/user").hasRole(ApiKeyRoles.USER.name())
                .requestMatchers("/admin").hasRole(ApiKeyRoles.ADMIN.name())
            );

        return http.build();
    }

    @Bean
    @Qualifier("providerManager")
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(apiKeyUserDetailsService);
        return provider;
    }

}
