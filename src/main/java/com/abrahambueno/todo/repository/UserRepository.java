package com.abrahambueno.todo.repository;

import com.abrahambueno.todo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String name);
}
