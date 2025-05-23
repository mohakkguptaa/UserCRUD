package com.example.UserCRUD.ControllersTest;

import com.example.UserCRUD.DTOs.UserRequestDTO;
import com.example.UserCRUD.Entities.User;
import com.example.UserCRUD.Repositories.UserRepo;
import com.example.UserCRUD.TestDTOs.UserResponseTestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserControllerTest {

    @LocalServerPort
    private int port = 8080;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private UserRepo userRepo;

    private String base_url = "http://localhost:" + port + "/user";

    private String id_base_url = "http://localhost:" + port + "/user/1";

    private String delete_base_url = "http://localhost:" + port + "/user/2";


    @Test
    void TestCreateUser(){
        UserRequestDTO request = new UserRequestDTO("Mohak", 23, "0909");

        ResponseEntity<UserResponseTestDTO> responseEntity = testRestTemplate.postForEntity(base_url, request, UserResponseTestDTO.class);

        UserResponseTestDTO body = responseEntity.getBody();

        assertNotNull(body);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Mohak", body.getName());

        Optional<User> user = userRepo.findById(body.getId());
        assertTrue(user.isPresent());
        assertEquals("Mohak", user.get().getName());
    }

    @Test
    void TestGetUserById(){

        ResponseEntity<UserResponseTestDTO> response = testRestTemplate.getForEntity(id_base_url, UserResponseTestDTO.class);

        UserResponseTestDTO body = response.getBody();

        assertNotNull(body);
        assertEquals("Rahul", body.getName());
    }

    @Test
    void TestDeleteUser(){
        testRestTemplate.delete(delete_base_url);

        Optional<User> user  = userRepo.findById(2);
        assertEquals(Optional.empty(), user);
    }

    @Test
    void TestUpdateUser(){
        UserRequestDTO request = new UserRequestDTO("Rahul", 24, "0909");
        testRestTemplate.put(id_base_url, request);

        Optional<User> user = userRepo.findById(1);

        assertEquals("Rahul", user.get().getName());
    }

}
