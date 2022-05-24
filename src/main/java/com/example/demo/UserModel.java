package com.example.demo;

public class UserModel {
    public Long id;
    public String username;
    public String password;

    public UserModel() {
    }

    public UserModel(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public static UserModel from(UserEntity userEntity) {
        return new UserModel(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword());
    }
}
