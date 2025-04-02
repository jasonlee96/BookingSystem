package com.jasonlee213.userservice.command.dto;

import lombok.Data;

@Data
public class CreateUserCommand {
    private String userName;
    private String password;
    private int roleID;
    private int statusID;

    public CreateUserCommand(String userName, String password, int roleID, int statusID) {
        this.userName = userName;
        this.password = password;
        this.roleID = roleID;
        this.statusID = statusID;
    }
}
