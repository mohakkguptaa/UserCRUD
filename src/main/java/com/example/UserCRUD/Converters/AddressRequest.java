package com.example.UserCRUD.Converters;

import com.example.UserCRUD.DTOs.AddressRequestDTO;
import com.example.UserCRUD.Entities.Address;
import com.example.UserCRUD.Entities.User;

public class AddressRequest {

    public static Address AddDTOToEntity(AddressRequestDTO addressRequestDTO){
        Address address = new Address();
        address.setArea(addressRequestDTO.getArea());
        address.setCity(addressRequestDTO.getCity());
        return address;
    }
}
