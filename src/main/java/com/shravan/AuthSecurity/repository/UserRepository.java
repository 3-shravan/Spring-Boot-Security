package com.shravan.AuthSecurity.repository;

import com.shravan.AuthSecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
