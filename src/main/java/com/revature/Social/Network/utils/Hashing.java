package com.revature.Social.Network.utils;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Hashing {

    @Bean
    public BasicPasswordEncryptor encryptor()
    {
        return new BasicPasswordEncryptor();
    }
}
