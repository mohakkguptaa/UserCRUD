package com.example.UserCRUD.Services;

import com.example.UserCRUD.DTOs.UserRequestDTO;
import com.example.UserCRUD.DTOs.UserResponseDTO;
import com.example.UserCRUD.Entities.User;
import com.example.UserCRUD.Exceptions.ResourceNotFound;
import com.example.UserCRUD.Repositories.UserRepo;
import org.springframework.stereotype.Service;
import static com.example.UserCRUD.Converters.UserRequest.DTOToEntity;
import static com.example.UserCRUD.Converters.UserResponse.EntityToDTO;

import java.util.ArrayList;
import java.util.List;



@Service
public class UserService {

    private final UserRepo userRepo;

    UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
        User user = DTOToEntity(userRequestDTO);
        User savedUser = userRepo.save(user);
        return  EntityToDTO(savedUser);
    }

    public UserResponseDTO getUserById(Integer id){
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Id:" + id + " Not Found"));
        return EntityToDTO(user);
    }

    public List<UserResponseDTO> getAllUsers(){
        List<User> users = userRepo.findAll();
        List<UserResponseDTO> userResponseList = new ArrayList<>();

        for(User user: users){
            userResponseList.add(EntityToDTO(user));
        }
        return userResponseList;
    }

    public void deleteUser(Integer id){
        userRepo.deleteById(id);
    }

    public User updateUser(Integer id, UserRequestDTO userRequestDTO){
        User user = DTOToEntity(userRequestDTO);
        User userUpd = userRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Id:" + id + " Not Found"));

        if(userUpd != null){
            userUpd.setName(user.getName());
            userUpd.setAge(user.getAge());
            userUpd.setPhone(user.getPhone());
            return userRepo.save(userUpd);
        }

        else{
            return null;
        }
    }

    public User testUser(Integer id){
        return userRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Id: " + id + "Not Found"));
    }

}
