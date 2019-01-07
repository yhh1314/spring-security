package com.example.demo.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.test.MyUser;
import com.example.demo.test.Role;

import java.lang.String;
import java.util.List;
import java.util.Map;

public interface MyUserRespo extends JpaRepository<MyUser, Integer> {
	List<MyUser> findByName(String name);
	@Query(value="select ro.name rname from my_user uu join my_user_roles ur on ur.user_id=uu.id join role ro on ro.id=ur.role_id where uu.id=? ",nativeQuery = true)
	List<Map> findRolesById(int id);
}
