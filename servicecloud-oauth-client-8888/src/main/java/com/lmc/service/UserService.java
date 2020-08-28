package com.lmc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lmc.beans.User;
import com.lmc.dao.UserDao;

@Service
public class UserService  {

    @Autowired
    private UserDao userDao;

    public User create(String username, String password){
    	User user = new User();
    	user.setUsername(username);
    	user.setPassword(password);
    	userDao.save(user);
    	return user;
    }
}
