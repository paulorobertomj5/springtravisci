package br.com.spring.restspringboot.api.service.impl;

import br.com.spring.restspringboot.api.model.UserModel;
import br.com.spring.restspringboot.api.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userDAO.getFindByUserName(username);
        return new User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }


}
