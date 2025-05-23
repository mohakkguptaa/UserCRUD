package com.example.UserCRUD.DTOs;

import com.example.UserCRUD.Entities.Address;
import lombok.Data;

import java.util.List;

@Data
public class UserRequestDTO {

    private String name;

    private int age;

    private String phone;

    public UserRequestDTO(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
}
