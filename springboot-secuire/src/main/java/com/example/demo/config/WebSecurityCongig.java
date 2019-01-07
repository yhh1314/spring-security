package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.service.MyUserSservice;
@Configuration
@EnableWebSecurity
public class WebSecurityCongig extends WebSecurityConfigurerAdapter{
	@Autowired
	private MyUserSservice myUserSservice;
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
//		auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncode()).withUser("admin").password("admin").roles("ADMIN");
//		auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncode()).withUser("user").password("user").roles("USER");
		auth.userDetailsService(myUserSservice).passwordEncoder(new MyPasswordEncode());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/").permitAll()
		/* .and()
		 .authorizeRequests()
		        .antMatchers("/user/**").hasRole("USER")
		        .antMatchers("/admin/**").hasRole("ADMIN")*/
		.anyRequest().authenticated()
		.and().logout().permitAll()
		.and()
		.formLogin();
		http.csrf().disable();
		
	}

}
