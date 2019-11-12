package com.tianya.dao;

import com.tianya.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


    User findByUsernameAndPassword(String username, String password);
}
