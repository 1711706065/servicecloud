package com.lmc.service;

import com.lmc.beans.User;
import com.lmc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		User user = userDao.findByUsername(s);
		if (user == null) {
			throw new UsernameNotFoundException(s);
		}
		System.out.println("userService = " + user.toString());
		return user;
	}
}
