package com.example.demo;

public class UserModel implements User {
    protected Long id;
    protected String username;
    protected String password;

    public UserModel() {
    }

    public UserModel(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public static UserModel from(User user) {
        return new UserModel(user.getId(), user.getUsername(), user.getPassword());
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
