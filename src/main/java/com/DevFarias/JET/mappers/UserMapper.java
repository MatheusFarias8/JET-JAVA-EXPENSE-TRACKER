package com.DevFarias.JET.mappers;

import com.DevFarias.JET.domain.dtos.user.CreateUserRequest;
import com.DevFarias.JET.domain.dtos.user.UpdateUserRequest;
import com.DevFarias.JET.domain.dtos.user.UserResponse;
import com.DevFarias.JET.domain.models.User;

import java.time.LocalDateTime;

public class UserMapper {
    public UserResponse toResponse(User user) {

        if (user == null) return null;

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt()
        );

    }

    public User toEntity(CreateUserRequest userRequest) {
        if (userRequest == null) return null;

        LocalDateTime createdAt = LocalDateTime.now();

        return User.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .createdAt(createdAt)
                .updatedAt(createdAt)
                .build();
    }

    public User updateEntity(User user, UpdateUserRequest userRequest) {
        if (userRequest == null) return null;

        user.setName(userRequest.name());
        user.setEmail(userRequest.email());

        return user;

    }
}
