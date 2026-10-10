package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    private final UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public Result getUser(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        Result result = new Result(200,"success",user);
        return result;
    }
    @GetMapping("/users")
    public Result getUserAll() {
        List<User> users = userService.findAll();
        Result result = new Result(200,"success",users);
        return result;
    }

    @PostMapping("/users")
    public Result addUser(@Valid @RequestBody User user){
        user = userService.addUser(user);
        Result result=new Result(200,"success",user);
        return result;
    }

    @PutMapping("/users/{id}")
    public Result updateUser(@PathVariable Integer id, @RequestBody User user){
        user.setId(id);
        user = userService.updateUser(user);
        Result result=new Result(200,"success",user);
        return result;
    }
    @DeleteMapping("/users/{id}")
    public Result deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return new Result(200,"success",null);
    }

}