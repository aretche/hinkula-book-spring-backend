package com.packt.cardatabase.service;

import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.domain.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    public UserDetailServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User currentUser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, currentUser.getPassword()
                , true, true, true, true, AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
    }

}