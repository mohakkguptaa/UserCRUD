package com.example.UserCRUD.Exceptions;

public class ResourceNotFound extends RuntimeException{

    public  ResourceNotFound(String message){
        super(message);
    }
}
