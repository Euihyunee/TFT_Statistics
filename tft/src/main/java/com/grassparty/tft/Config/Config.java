package com.grassparty.tft.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    // passing the key which you set in application.properties
    @Value("${api_key}")
    private static String api_key;

    // getting the value from that key which you set in application.properties
    @Bean
    public String api_key() {
        return api_key;
    }
}
