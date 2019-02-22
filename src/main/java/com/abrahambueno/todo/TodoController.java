package com.abrahambueno.todo;

import com.abrahambueno.todo.models.User;
import com.abrahambueno.todo.repository.TodoRepository;
import com.abrahambueno.todo.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Todo application", description = "An application that takes todo items from a user, with CRUD")
@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class TodoController {
    @Autowired
    TodoRepository todorepos;

    @Autowired
    UserRepository userrepos;

    @ApiOperation(value = "list all Users", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ""),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userrepos.findAll();
    }
}
