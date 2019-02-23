package com.abrahambueno.todo;

import com.abrahambueno.todo.models.Todo;
import com.abrahambueno.todo.models.User;
import com.abrahambueno.todo.repository.TodoRepository;
import com.abrahambueno.todo.repository.UserRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Api(value = "Todo application", description = "An application that takes todo items from a user, with CRUD")
@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "successfully retrieve list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
})
public class TodoController {
    @Autowired
    TodoRepository todorepos;

    @Autowired
    UserRepository userrepos;

    @ApiOperation(value = "list all Users", response = List.class)
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userrepos.findAll();
    }
    @PostMapping("/users")
    public User createUser(@RequestBody User user) throws URISyntaxException {
        return userrepos.save(user);
    }
    @GetMapping("/users/userid/{userid}")
    public User findUserByUserid(@PathVariable long userid) {
        Optional<User> foundUser = userrepos.findById(userid);

        if (foundUser.isPresent()) {
            return foundUser.get();
        } else {
            return null;
        }
    }

    @GetMapping("/users/username/{username}")
    public User findUserByUsername(@PathVariable String username) {
        User foundUser = userrepos.findByUsername(username);
        if (foundUser != null) {
            return foundUser;
        } else {
            return null;
        }
    }
    @PutMapping("/users/userid/{userid}")
    public User changeUser(@RequestBody User newuser, @PathVariable long userid) throws URISyntaxException {
        Optional<User> updateUser = userrepos.findById(userid);
        if (updateUser.isPresent()) {
            newuser.setUserid(userid);
            userrepos.save(newuser);
            return newuser;
        } else {
            return null;
        }
    }
    @DeleteMapping("users/userid/{userid}")
    public User deleteUser(@PathVariable long userid) {
        Optional<User> foundUser = userrepos.findById(userid);
        if (foundUser.isPresent()) {
            userrepos.deleteById(userid);
            return foundUser.get();
        } else {
            return null;
        }
    }

    @ApiOperation(value = "list all Todo", response = List.class)
    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return todorepos.findAll();
    }
    // no swagger
    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo todo) throws URISyntaxException {
        return todorepos.save(todo);
    }
//    the todo data doesn't have any relation to a user, it's just a list with no user association
//    @GetMapping("/todos/users")
//    public List<Object[]> userTodos() {
//        return todorepos.todoOfUsers();
//    }
    //

    @ApiOperation(value = "list all Todo completed", response = List.class)
    @GetMapping("/todos/active")
    public List<Todo> getListNotCompleted() {
        return todorepos.getAllCompleted();
    }
    // no swagger
    @GetMapping("/todos/todoid/{todoid}")
    public Todo getTodoByTodoid(@PathVariable long todoid) {
        Optional<Todo> foundTodo = todorepos.findById(todoid);
        if (foundTodo.isPresent()) {
            return foundTodo.get();
        } else {
            return null;
        }
    }
    @ApiOperation(value = "list Todo by id", response = Todo.class)
    @PutMapping("/todos/todoid/{todoid}")
    public Todo changeTodo(@RequestBody Todo todo, @ApiParam(value = "This is the todo id", required = true) @PathVariable long id) {
        Optional<Todo> updateTodo = todorepos.findById(id);
        if (updateTodo.isPresent()) {
            todo.setTodoid(id);
            todorepos.save(todo);
            return todo;
        } else {
            return null;
        }
    }
    @ApiOperation(value = "Delete Todo by id", response = Todo.class)
    @DeleteMapping("/todos/todoid/{todoid}")
    public Todo deleteTodo(@ApiParam(value = "This is the todo id", required = true) @PathVariable long todoid) {
        Optional<Todo> foundTodo = todorepos.findById(todoid);
        if (foundTodo.isPresent()) {
            todorepos.deleteById(todoid);
            return foundTodo.get();
        } else {
            return null;
        }
    }

}
