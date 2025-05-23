package com.example.UserCRUD.Converters;

import com.example.UserCRUD.DTOs.AddressResponseDTO;
import com.example.UserCRUD.DTOs.UserResponseDTO;
import com.example.UserCRUD.Entities.Address;

import static com.example.UserCRUD.Converters.UserResponse.EntityToDTO;

public class AddressResponse {
    public static AddressResponseDTO AddEntityToDTO(Address address){
        AddressResponseDTO addressResponseDTO = new AddressResponseDTO();
        addressResponseDTO.setId(address.getAddress_id());
        addressResponseDTO.setArea(address.getArea());
        addressResponseDTO.setCity(address.getCity());
        UserResponseDTO userResponseDTO = EntityToDTO(address.getUser());
        addressResponseDTO.setUser(userResponseDTO);

        return addressResponseDTO;

    }
}
