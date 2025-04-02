package com.jasonlee213.userservice.command.repository;

import com.jasonlee213.userservice.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommandRepository extends JpaRepository<UserModel, Long> {

}
