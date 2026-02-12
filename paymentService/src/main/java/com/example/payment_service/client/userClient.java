package com.example.payment_service.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class userClient {
    private  final RestTemplate restTemplate;

    @Value("${user.service.base-url}")
    private String userServiceBaseUrl;

    public userClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public void validateUser(Long userId){
        String url = userServiceBaseUrl +"/users/"+userId;

        try {
            restTemplate.getForObject(url, Object.class);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }
}
