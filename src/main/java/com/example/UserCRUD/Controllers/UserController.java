package com.example.UserCRUD.Controllers;

import com.example.UserCRUD.DTOs.UserRequestDTO;
import com.example.UserCRUD.DTOs.UserResponseDTO;
import com.example.UserCRUD.Entities.User;
import com.example.UserCRUD.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<UserResponseDTO> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody UserRequestDTO userRequestDTO){
        return userService.updateUser(id, userRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }

    @GetMapping("test/{id}")
    public User testUser(@PathVariable Integer id){
        return userService.testUser(id);
    }

}
