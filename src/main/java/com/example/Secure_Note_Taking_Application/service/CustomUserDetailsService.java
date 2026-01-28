package com.example.Secure_Note_Taking_Application.service;

import com.example.Secure_Note_Taking_Application.entity.AppUser;
import com.example.Secure_Note_Taking_Application.repository.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AppUserRepo appUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = appUserRepo.findByUsername(username).orElseThrow();

        return User.builder().
                username(username).
                password(appUser.getPassword()).
                authorities(appUser.getRoles().
                        stream().
                        map(role -> new SimpleGrantedAuthority("ROLES_"+role.toUpperCase())).toList()).
                build();
    }

}

