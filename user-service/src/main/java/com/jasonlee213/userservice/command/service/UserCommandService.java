package com.jasonlee213.userservice.command.service;

import com.jasonlee213.userservice.command.dto.CreateUserCommand;
import com.jasonlee213.userservice.command.event.UserCreatedEvent;
import com.jasonlee213.userservice.command.repository.UserCommandRepository;
import com.jasonlee213.userservice.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserCommandService {
    @Autowired
    private UserCommandRepository userRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;  // Publishes events

    public void handleCreateUser(CreateUserCommand command) {
        UserModel user = new UserModel(command.getUserName(), command.getPassword(), command.getRoleID(), command.getStatusID());
        userRepository.save(user);

        // Publish event to notify other microservices
        // use Kafka instead ApplicationEventPublisher if signaling across services
        eventPublisher.publishEvent(new UserCreatedEvent(this, user.getId(), user.getUserName(), user.getRoleID(), user.getStatusID()));
    }
}
