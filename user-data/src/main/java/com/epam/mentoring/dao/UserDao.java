package com.epam.mentoring.dao;

import com.epam.mentoring.bean.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends Repository<User, Long> {

    @Query(value = "FROM User usr WHERE usr.email = ?1")
    User getUserByEmail(@Param("email") String email);

    @Query(value = "From User")
    List<User> getAllUsers();

}
