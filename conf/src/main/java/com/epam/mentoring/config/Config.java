package com.epam.mentoring.config;

import com.epam.mentoring.bean.User;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackageClasses = {com.epam.mentoring.dao.UserDao.class})
@EntityScan(basePackageClasses = {User.class})
public class Config {

    
}
