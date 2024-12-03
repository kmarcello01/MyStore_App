package com.webproject.MyStore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.webproject.MyStore.models.AppUser;
import com.webproject.MyStore.repositories.AppUserRepository;

@Service
public class AppUserService implements UserDetailsService{
    @Autowired
    private AppUserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = repo.findByEmail(email);

        if (appUser != null) {
            var springUser = User.withUsername(appUser.getEmail())
                        .password(appUser.getPassword())
                        .roles(appUser.getRole())
                        .build();

            return springUser;
        }
        return null;
    }

}
