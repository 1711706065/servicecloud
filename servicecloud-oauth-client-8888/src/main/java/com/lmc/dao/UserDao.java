package com.lmc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmc.beans.User;

public interface UserDao extends JpaRepository<User, Long> {
    
}
