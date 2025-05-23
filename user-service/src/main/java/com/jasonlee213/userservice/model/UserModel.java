package com.jasonlee213.userservice.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;

@Entity
@Data
@Table(name = "users", schema = "obs")
public class UserModel {
    public UserModel(String userName, String password, String email, int roleID, int statusID){
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.roleID = roleID;
        this.statusID = statusID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String email;

    private String password;

    private int roleID;

    private int statusID;

    private Instant createdAt;

    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
    }
}