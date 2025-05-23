package com.example.UserCRUD.DTOs;

import com.example.UserCRUD.Entities.Address;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;


@Data
public class UserResponseDTO {
    private int id;

    private String name;

    private int age;

    private String phone;

    @JsonManagedReference
    private List<Address> address;

    public UserResponseDTO(int id, String name, int age, String phone, List<Address> address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    public UserResponseDTO() {
    }
}
