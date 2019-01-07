package com.example.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.config.MyUserRespo;
import com.example.demo.config.RoleRespo;
import com.example.demo.test.MyUser;
import com.example.demo.test.Role;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSecuireApplicationTests {

	@Autowired
	private MyUserRespo respo;
	@Autowired
	private RoleRespo respo1;
	@Test
	public void contextLoads() {
	}
	@Test
	public void addUser(){
		MyUser user=new MyUser();
		user.setName("hello");
		user.setPassword("123456");
		user.setAge(15);
		Set<Role> roles=new HashSet<Role>();
		roles.add(new Role("ADMIN"));
		roles.add(new Role("USER"));
		user.setRoles(roles);
		respo.save(user);
	}
	@Test
	public void findUser(){
	
		/*Optional<MyUser> user = respo.findById(1);
		MyUser myUser = user.get();
		for (Role role : myUser.getRoles()) {
			System.out.println("ROLE:"+role);
		}*/
//		System.out.println(myUser);
		List<Map> roles = respo.findRolesById(1);
		for (Map kv : roles) {
			Set<Entry<String,Object>> entrySet= kv.entrySet();
			for (Entry<String, Object> e : entrySet) {
				System.out.println(e.getKey()+":"+e.getValue());
			}
		}
		
	}
	@Test
	public void findRoles(){
		List<Role> findAll = respo1.findAll();
		for (Role role : findAll) {
			System.out.println(role);
		}
	}
}

