package org.humanitarian.collector.auth.services;

import org.humanitarian.collector.auth.models.User;
import org.humanitarian.collector.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User u = userRepository.findOneByUsername(s);

        if (u == null) {
            throw new UsernameNotFoundException("User not found.");
        }

        return u;
    }
}
