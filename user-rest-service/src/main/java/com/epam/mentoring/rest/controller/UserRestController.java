package com.epam.mentoring.rest.controller;

import com.epam.mentoring.bean.User;
import com.epam.mentoring.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/find/{email:.+}", method = RequestMethod.GET)
    public User getUserByEmail(@PathVariable(name = "email") String email) {
        return userService.getUserByEmail(email);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
