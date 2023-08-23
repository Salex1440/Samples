package com.salex.springsecurity.security.apikey;

import com.salex.springsecurity.security.apikey.dao.FakeUserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApiKeyUserDetailsService implements UserDetailsService {

    @Autowired
    @Qualifier("fake")
    private FakeUserDaoImpl userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findUserByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("ApiKey %s not found", username)));
    }
}
