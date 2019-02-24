package com.abrahambueno.todo.repository;

import com.abrahambueno.todo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Query(value = "select * t, u.usernmae from todo, users u where t.userid = t.userid ", nativeQuery = true)
    List<Object[]> todoOfUsers();

    @Query(value = "select  * from todo where todo.completed = 1", nativeQuery = true)
    List<Todo> getAllCompleted();
}
