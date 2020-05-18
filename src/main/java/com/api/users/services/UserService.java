package com.api.users.services;

import com.api.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${clienteRest.urlApi}")
    private String urlApi;

    public List<User> getAllUser() {
        ResponseEntity<List<User>> response = restTemplate.exchange(urlApi, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        });
        List<User> userList = response.getBody();
        return userList;
    }

    public User findById(@PathVariable Long id) {

        ResponseEntity<User> response = restTemplate.exchange(urlApi + id, HttpMethod.GET, null, User.class );
        User userList = response.getBody();

        return userList;
    }
}
