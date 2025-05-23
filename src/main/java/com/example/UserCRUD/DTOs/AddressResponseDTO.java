package com.example.UserCRUD.DTOs;

import com.example.UserCRUD.Entities.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
public class AddressResponseDTO {
    private int id;

    private String area;

    private String city;

    @JsonBackReference
    private UserResponseDTO user;
}
