package com.jasonlee213.userservice.command.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CreateUserCommand {
    @Getter @Setter
    private String userName;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private int roleID;
    @Getter @Setter
    private int statusID;

    public CreateUserCommand(String userName, String password, String email, int roleID, int statusID) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.roleID = roleID;
        this.statusID = statusID;
    }
}
