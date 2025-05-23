package com.example.UserCRUD.TestDTOs;


import com.example.UserCRUD.Entities.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Data
public class UserResponseTestDTO {
    private int id;

    private String name;

    private int age;

    private String phone;

    @JsonIgnore
    @JsonManagedReference
    private List<Address> address;
}



