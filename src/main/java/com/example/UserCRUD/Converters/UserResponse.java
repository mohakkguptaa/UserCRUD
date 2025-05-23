package com.example.UserCRUD.Converters;

import com.example.UserCRUD.DTOs.UserRequestDTO;
import com.example.UserCRUD.DTOs.UserResponseDTO;
import com.example.UserCRUD.Entities.User;

public class UserResponse {

    public static UserResponseDTO EntityToDTO(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getUser_id());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setAge(user.getAge());
        userResponseDTO.setPhone(user.getPhone());
        userResponseDTO.setAddress(user.getAddress());

        return userResponseDTO;
    }
}
