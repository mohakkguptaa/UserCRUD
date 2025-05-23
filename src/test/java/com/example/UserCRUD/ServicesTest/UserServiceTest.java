package com.example.UserCRUD.ServicesTest;

import com.example.UserCRUD.DTOs.UserRequestDTO;
import com.example.UserCRUD.DTOs.UserResponseDTO;
import com.example.UserCRUD.Entities.User;
import com.example.UserCRUD.Exceptions.ResourceNotFound;
import com.example.UserCRUD.Repositories.UserRepo;
import com.example.UserCRUD.Services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserService userService;

    @Test
    void TestById(){
        User user = new User(1, "Mohak", 23, "0909", Collections.emptyList());

        when(userRepo.findById(1)).thenReturn(Optional.of(user));

        UserResponseDTO result = userService.getUserById(1);

        assertEquals("Mohak", result.getName());
    }

    @Test
    void TestByIDNull(){
        when(userRepo.findById(99)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFound.class, () -> userService.getUserById(99));
    }

    @Test
    void TestCreate(){
        UserRequestDTO requestUser = new UserRequestDTO("Mohak", 23, "0909");

        User inputUser = new User("Mohak", 23, "0909");
        User user = new User(1, "Mohak", 23, "0909", Collections.emptyList());

        when(userRepo.save(inputUser)).thenReturn(user);

        UserResponseDTO result = userService.createUser(requestUser);

        assertEquals("0909", result.getPhone());
    }

    @Test
    void TestUpdate(){
        UserRequestDTO requestUser = new UserRequestDTO("Rahul", 23, "0909");

        User user = new User(1, "Mohak", 24, "0909", Collections.emptyList());

        when(userRepo.findById(1)).thenReturn(Optional.of(user));
        when(userRepo.save(user)).thenReturn(user);


        User result = userService.updateUser(1, requestUser);
        System.out.println(result.getName());

        assertEquals(1, result.getUser_id());
        assertEquals("Rahul", result.getName() );
        assertEquals(23, result.getAge());
    }

}
