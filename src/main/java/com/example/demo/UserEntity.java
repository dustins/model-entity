package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class UserEntity implements User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdDate = LocalDateTime.now();

    public UserEntity() {
    }

    public UserEntity(Long id, String username, String password, LocalDateTime createdDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public static UserEntity from(User user) {
        return new UserEntity(user.getId(), user.getUsername(), user.getPassword(), LocalDateTime.now());
    }
}
