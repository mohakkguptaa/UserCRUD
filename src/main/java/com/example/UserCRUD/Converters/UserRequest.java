package com.example.UserCRUD.Converters;

import com.example.UserCRUD.DTOs.UserRequestDTO;
import com.example.UserCRUD.Entities.User;

public class UserRequest {
    public static User DTOToEntity(UserRequestDTO userRequestDTO){
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setAge(userRequestDTO.getAge());
        user.setPhone(userRequestDTO.getPhone());
        return user;
    }
}
