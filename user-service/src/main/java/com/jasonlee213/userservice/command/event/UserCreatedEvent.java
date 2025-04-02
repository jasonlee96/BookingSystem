package com.jasonlee213.userservice.command.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

public class UserCreatedEvent extends ApplicationEvent {
    @Getter @Setter
    private Long userId;
    @Getter @Setter
    private String userName;
    @Getter @Setter
    private int roleID;
    @Getter @Setter
    private int statusID;


    public UserCreatedEvent(Object source, Long userId, String userName, int roleID, int statusID) {
        super(source);
        this.userId = userId;
        this.roleID = roleID;
        this.userName = userName;
        this.statusID = statusID;
    }

}
