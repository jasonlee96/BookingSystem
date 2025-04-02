package com.jasonlee213.userservice.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;

@Entity
@Table(name = "users", schema = "obs")
public class UserModel {
    public UserModel(String userName, String password, int roleID, int statusID){
        this.userName = userName;
        this.password = password;
        this.roleID = roleID;
        this.statusID = statusID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String userName;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private int roleID;

    @Getter @Setter
    private int statusID;

    @Getter @Setter
    private Instant createdAt;

    @Getter @Setter
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