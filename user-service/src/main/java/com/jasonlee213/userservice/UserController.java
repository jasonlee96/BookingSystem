package com.jasonlee213.userservice;

import com.jasonlee213.common.dtos.CommonResponse;
import com.jasonlee213.common.dtos.user.UserDTO;
import com.jasonlee213.common.enums.ApiResponseEnum;
import com.jasonlee213.userservice.command.dto.CreateUserCommand;
import com.jasonlee213.userservice.command.service.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserCommandService userCommandService;

    @PostMapping
    public CommonResponse createUser(@RequestBody UserDTO user) {
        // Create a command object
        CreateUserCommand command = new CreateUserCommand(user.getUserName(), user.getPassword(), user.getRoleID(), user.getStatusID());

        // Call the service layer to handle the command
        userCommandService.handleCreateUser(command);

        return new CommonResponse(ApiResponseEnum.Success.getStatusID(), ApiResponseEnum.Success.toString());
    }
}
