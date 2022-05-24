package com.example.demo;

import com.google.common.collect.Lists;
import com.google.common.collect.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UserModel> list() {
        return Streams.stream(userRepository.findAll())
                .map(UserModel::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> get(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserModel userModel) {
        UserEntity userEntity = UserEntity.from(userModel);
        userEntity = userRepository.save(userEntity);

        return new ResponseEntity<>(UserModel.from(userEntity), HttpStatus.CREATED);
    }
}
