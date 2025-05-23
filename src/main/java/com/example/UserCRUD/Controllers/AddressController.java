package com.example.UserCRUD.Controllers;

import com.example.UserCRUD.DTOs.AddressRequestDTO;
import com.example.UserCRUD.DTOs.AddressResponseDTO;
import com.example.UserCRUD.Entities.Address;
import com.example.UserCRUD.Services.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private final AddService addService;

    AddressController(AddService addService){
        this.addService = addService;
    }

    @PostMapping
    public AddressResponseDTO createAddress(@RequestBody AddressRequestDTO address){
        return addService.createAddress(address);
    }

    @GetMapping
    public List<AddressResponseDTO> getAddresses(){
        return addService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public AddressResponseDTO getAddressById(@PathVariable Integer id){
        return addService.getAddressById(id);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Integer id, @RequestBody AddressRequestDTO addressRequestDTO){
        return addService.updateAddress(id, addressRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id){
        addService.deleteAddress(id);
    }

}
