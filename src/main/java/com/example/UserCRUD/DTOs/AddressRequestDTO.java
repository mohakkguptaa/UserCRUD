package com.example.UserCRUD.DTOs;

import lombok.Data;

@Data
public class AddressRequestDTO {
    private String area;

    private String city;

    private int user_id;

}
