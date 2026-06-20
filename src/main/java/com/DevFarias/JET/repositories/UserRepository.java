package com.DevFarias.JET.repositories;

import com.DevFarias.JET.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
