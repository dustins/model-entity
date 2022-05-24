package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.http.HttpRequest;

@Service
public class UserService {
    protected WebClient webClient = WebClient.builder()
            .baseUrl("http://127.0.0.1:8080")
            .build();

    public UserModel save(UserModel userModel) {
        return webClient.post()
                .uri("/users")
                .body(BodyInserters.fromValue(userModel))
                .retrieve()
                .bodyToMono(UserModel.class)
                .block();
    }
}
