package com.jasonlee213.userservice.query.service;

import com.jasonlee213.common.dtos.user.UserDTO;
import com.jasonlee213.userservice.command.dto.CreateUserCommand;
import com.jasonlee213.userservice.command.event.UserCreatedEvent;
import com.jasonlee213.userservice.command.repository.UserCommandRepository;
import com.jasonlee213.userservice.model.UserModel;
import com.jasonlee213.userservice.query.repository.UserQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserQueryService {
    @Autowired
    private UserQueryRepository userRepository;

    public UserDTO findUserByID(Long userID) {
        Optional<UserModel> userData = userRepository.findById(userID);

        if(userData.isEmpty()) return null;

        var user = userData.get();
        return new UserDTO(user.getId(), user.getUserName(), user.getEmail(), user.getRoleID(), user.getStatusID(),
                user.getCreatedAt(), user.getUpdatedAt());
    }

    public List<UserDTO> findUserByDateRange(LocalDateTime dateFrom, LocalDateTime dateTo) {
        List<UserModel> userData = userRepository.findByUpdatedAtBetween(dateFrom, dateTo);

        if(userData.isEmpty()) return null;

        return userData.stream().map(x ->
                    new UserDTO(x.getId(), x.getUserName(), x.getEmail(), x.getRoleID(), x.getStatusID(),
                    x.getCreatedAt(), x.getUpdatedAt()))
                .collect(Collectors.toList());
    }
}
