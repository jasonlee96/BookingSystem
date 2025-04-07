package com.jasonlee213.common.dtos.user;

import com.jasonlee213.common.enums.RoleEnum;
import lombok.Data;

import java.time.Instant;

@Data
public class UserDTO {
    public UserDTO(Long id, String userName, String email, int roleID, int statusID, Instant createdAt, Instant updatedAt){
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.roleID = roleID;
        this.statusID = statusID;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    private Long id;
    private String userName;
    private String password;
    private String email;
    private int roleID;
    private int statusID;
    private Instant createdAt;
    private Instant updatedAt;

    public boolean isAdmin(){
        return this.roleID == RoleEnum.Admin.getRoleID();
    }

}
