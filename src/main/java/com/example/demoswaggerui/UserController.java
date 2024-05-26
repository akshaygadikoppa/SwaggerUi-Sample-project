package com.example.demoswaggerui;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @ApiOperation(value = "Get list of users", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/api/users")
    public List<String> getUsers() {
        return Arrays.asList("John Doe", "Jane Doe");
    }

    @ApiOperation(value = "Get user by ID")
    @GetMapping("/api/users/{id}")
    public String getUserById(@PathVariable("id") String id) {
        return "User " + id;
    }
}
