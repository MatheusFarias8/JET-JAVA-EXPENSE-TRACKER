package com.DevFarias.JET.services;

import com.DevFarias.JET.domain.dtos.user.CreateUserRequest;
import com.DevFarias.JET.domain.dtos.user.UserResponse;
import com.DevFarias.JET.domain.models.User;
import com.DevFarias.JET.exceptions.UserAlreadyExistsException;
import com.DevFarias.JET.mappers.UserMapper;
import com.DevFarias.JET.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private void validateEmailAvailability(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new UserAlreadyExistsException();
        }
    }

    @Transactional
    public UserResponse create(CreateUserRequest request) {

        validateEmailAvailability(request.email());

        User user = userMapper.toEntity(request);
        User savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }

}
