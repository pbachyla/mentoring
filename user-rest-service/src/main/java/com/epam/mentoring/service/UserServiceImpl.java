package com.epam.mentoring.service;

import com.epam.mentoring.bean.User;
import com.epam.mentoring.dao.UserDao;
import com.epam.mentoring.dto.UserDto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource(name = "usersRestTemplate")
    private RestTemplate usersRestTemplate;

    private UriComponentsBuilder uriBuilder;

    public UserServiceImpl(@Value("#{environment['github.users.service.url']}") String baseURL) {
        uriBuilder = UriComponentsBuilder.fromUriString(baseURL);
    }

    @Override
    public User getUserByEmail(String email) {
        User user = userDao.getUserByEmail(email);
        if (user == null) return null;

        UserDto gitHubUser = usersRestTemplate.getForObject(uriBuilder.cloneBuilder()
                                                                      .path("")
                                                                      .queryParam("q", user.getLogin())
                                                                      .build(true)
                                                                      .toUri(), UserDto.class);

        if (gitHubUser.getTotal_count() != 1 || gitHubUser.isResultComplete())
            return user;

        user.setPhoto(gitHubUser.getItems().get(0).getAvatarUrl());
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
