package com.example.demo.config;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.test.MyUser;
import com.example.demo.test.Role;

public interface RoleRespo extends JpaRepository<Role, Integer>{

}
