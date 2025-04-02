package com.jasonlee213.common.dtos.user;

import lombok.Data;

import java.time.Instant;

@Data
public class UserDTO {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private int roleID;
    private int statusID;
    private Instant createdAt;
    private Instant updatedAt;

}
