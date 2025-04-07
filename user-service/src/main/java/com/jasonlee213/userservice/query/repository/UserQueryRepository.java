package com.jasonlee213.userservice.query.repository;

import com.jasonlee213.userservice.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface UserQueryRepository  extends JpaRepository<UserModel, Long> {
    List<UserModel> findByUpdatedAtBetween(LocalDateTime dateFrom, LocalDateTime dateTo);
}
