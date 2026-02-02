package com.mpb.petadoptionagency.dto;

import jakarta.validation.constraints.NotNull;

public class UserDTO {

    @NotNull

    private Long id;
    @NotNull

    private String username;
    @NotNull

    private String permissionLevel;
    @NotNull

    private String password;

    public UserDTO() {
    }


    public UserDTO(String username, String password, String permissionLevel) {
        this.username = username;
        this.password = password;
        this.permissionLevel = permissionLevel;
    }

    // Getters and setters
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

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }



}