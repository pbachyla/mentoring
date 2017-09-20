package com.epam.mentoring.rest.client;

import com.epam.mentoring.config.TimeoutHelper;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

@Configuration
@Import(TimeoutHelper.class)
public class RestClientConfig {

    @Resource
    TimeoutHelper timeoutHelper;

    public RestTemplate createRestTemplate(String service) {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setReadTimeout(timeoutHelper.getReadTimeout(service));
        requestFactory.setConnectTimeout(timeoutHelper.getConnectTimeout(service));
        requestFactory.setConnectionRequestTimeout(timeoutHelper.getConnectTimeout(service));

        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(requestFactory));
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        restTemplate.setInterceptors(interceptors);

        return restTemplate;
    }

}
