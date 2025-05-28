package com.example.UserCRUD.Services;

import com.example.UserCRUD.DTOs.AddressRequestDTO;
import com.example.UserCRUD.DTOs.AddressResponseDTO;
import com.example.UserCRUD.Entities.Address;
import com.example.UserCRUD.Entities.User;
import com.example.UserCRUD.Repositories.AddRepo;
import com.example.UserCRUD.Repositories.UserRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import static com.example.UserCRUD.Converters.AddressRequest.AddDTOToEntity;
import static com.example.UserCRUD.Converters.AddressResponse.AddEntityToDTO;

@Service
@Transactional
public class AddService {

    @Autowired
    private AddRepo addRepo;

    @Autowired
    private UserRepo userRepo;

    @PersistenceContext
    private EntityManager entityManager;

    public AddressResponseDTO createAddress(AddressRequestDTO addressRequestDTO){
        Address address = AddDTOToEntity(addressRequestDTO);
        User user = userRepo.findById(addressRequestDTO.getUser_id()).orElse(null);
        address.setUser(user);
        Address savedAddress = addRepo.save(address);
        return  AddEntityToDTO(savedAddress);
    }

    public AddressResponseDTO getAddressById(Integer id){
        Address address = addRepo.findById(id).orElse(null);
        return AddEntityToDTO(address);
    }

    public List<AddressResponseDTO> getAllAddresses(){
        List<Address> addresses = addRepo.findAll();
        List<AddressResponseDTO> addressResponseList = new ArrayList<>();

        for(Address address: addresses){
            addressResponseList.add(AddEntityToDTO(address));
        }
        return addressResponseList;
    }

    public void deleteAddress(Integer id){
        addRepo.deleteById(id);
    }

    public Address updateAddress(Integer id, AddressRequestDTO addressRequestDTO){
        Address addUpd = addRepo.findById(id).orElse(null);
        User user = userRepo.findById(addressRequestDTO.getUser_id()).orElse(null);

        if(addUpd != null){
            addUpd.setArea(addressRequestDTO.getArea());
            addUpd.setCity(addressRequestDTO.getCity());
            addUpd.setUser(user);
            addRepo.save(addUpd);


//            for transactional behavior
//            entityManager.flush();
////
//            if(true){
//                throw new RuntimeException("Rollback testing");
//            }

            return addUpd;
        }

        else{
            return null;
        }
    }

}
