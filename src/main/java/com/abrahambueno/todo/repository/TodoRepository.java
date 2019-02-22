package com.abrahambueno.todo.repository;

import com.abrahambueno.todo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
