package com.example.UserCRUD.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    private String name;

    private int age;

    private String phone;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Address> address;

    public User(int user_id, String name, int age, String phone, List<Address> address) {
        this.user_id = user_id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    public User(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
}
