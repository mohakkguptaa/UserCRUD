package com.example.UserCRUD.Repositories;

import com.example.UserCRUD.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddRepo extends JpaRepository<Address, Integer> {
}
