package com.jasonlee213.userservice;

import com.jasonlee213.common.dtos.CommonDataResponse;
import com.jasonlee213.common.dtos.CommonListDataResponse;
import com.jasonlee213.common.dtos.CommonResponse;
import com.jasonlee213.common.dtos.user.UserDTO;
import com.jasonlee213.common.enums.ApiResponseEnum;
import com.jasonlee213.userservice.command.dto.CreateUserCommand;
import com.jasonlee213.userservice.command.service.UserCommandService;
import com.jasonlee213.userservice.query.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserCommandService userCommandService;
    @Autowired
    private UserQueryService userQueryService;

    @GetMapping("/{id}")
    public CommonDataResponse<UserDTO> getUserByID(@PathVariable Long id) {
        var data = userQueryService.findUserByID(id);

        return new CommonDataResponse<>(ApiResponseEnum.Success.getStatusID(), ApiResponseEnum.Success.toString(), data);
    }

    @GetMapping
    public CommonListDataResponse<UserDTO> getUsersByDateRange(
            @RequestParam("dateFrom") String dateFrom,
            @RequestParam("dateTo") String dateTo) {
        LocalDateTime from = LocalDateTime.parse(dateFrom);
        LocalDateTime to = LocalDateTime.parse(dateTo);
        var data = userQueryService.findUserByDateRange(from, to);
        return new CommonListDataResponse<>(ApiResponseEnum.Success.getStatusID(), ApiResponseEnum.Success.toString(), data);
    }

    @PostMapping
    public CommonResponse createUser(@RequestBody UserDTO user) {
        // Create a command object
        CreateUserCommand command = new CreateUserCommand(user.getUserName(), user.getPassword(), user.getEmail(), user.getRoleID(), user.getStatusID());

        // Call the service layer to handle the command
        userCommandService.handleCreateUser(command);

        return new CommonResponse(ApiResponseEnum.Success.getStatusID(), ApiResponseEnum.Success.toString());
    }
}
