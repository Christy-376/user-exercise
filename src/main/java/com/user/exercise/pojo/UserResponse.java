package com.user.exercise.pojo;

public class UserResponse {
    private Long id;
    private String username;
    private boolean active;

    // Constructors, Getters, and Setters
    public UserResponse() {}

    public UserResponse(Long id, String username, boolean active) {
        this.id = id;
        this.username = username;
        this.active = active;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

