package com.example.demo.controller;



import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping(value="/user/hello")
	public String hello(){
		return "hello springboot";
	}
	@GetMapping(value="/")
	public String index(){
		return "index";
	}
	@GetMapping(value="/admin/auth")
	@PreAuthorize("hasRole('ROLE_ADMIN')")

	public String auth(){
		return "有admin才能看到";
	}
	@GetMapping(value="/test")
	@PreAuthorize("hasRole('ROLE_SUPER')")
	public String test(){
		return "有admin才能看到";
	}
}
