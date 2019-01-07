package com.example.demo.service;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.config.MyUserRespo;
import com.example.demo.test.MyUser;
import com.example.demo.test.Role;

@Component
public class MyUserSservice implements UserDetailsService {
	@Autowired
	private MyUserRespo myUserRespo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<MyUser> users = myUserRespo.findByName(username);
		if(users.size()<=0){
			throw new UsernameNotFoundException("username not exist");
			
		}else{
			MyUser myUser = users.get(0);
			Set<Role> roles = myUser.getRoles();
			if(myUser!=null){
				List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
				for (Role role : roles) {
					authorities.add(new SimpleGrantedAuthority(role.getName()));
					System.out.println("角色有："+role.getName());
				}
				return new User(myUser.getName(),myUser.getPassword(),authorities);
			}
			throw new UsernameNotFoundException("username not exist");
		}
		
		
	}

}
