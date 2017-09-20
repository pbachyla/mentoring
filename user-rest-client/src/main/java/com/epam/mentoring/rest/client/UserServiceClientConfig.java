package com.epam.mentoring.rest.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserServiceClientConfig extends RestClientConfig{

    @Bean
    public RestTemplate usersRestTemplate() {
        return createRestTemplate("users");
    }

}
