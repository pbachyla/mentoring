package com.epam.mentoring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;

@Component
public class TimeoutHelper {

    @Value("${default.service.read.timeout:1000}")
    private int defaultReadTimeout;

    @Value("${default.service.connect.timeout:2000}")
    private int defaultConnectTimeout;

    @Resource
    Environment environment;

    public int getReadTimeout(String service) {
        return environment.getProperty(service + ".service.read.timeout", Integer.class, defaultReadTimeout);
    }

    public int getConnectTimeout(String service) {
        return environment.getProperty(service + ".service.connect.timeout", Integer.class, defaultConnectTimeout);
    }

}
