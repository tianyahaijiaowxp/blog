package com.tianya.service;

import com.tianya.po.User;

public interface UserService {

    User checkUser(String username, String password);
}
