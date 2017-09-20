package com.epam.mentoring.service;

import com.epam.mentoring.bean.User;

import java.util.List;

public interface UserService {

    User getUserByEmail(String email);

    List<User> getAllUsers();

}
