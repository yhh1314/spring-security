package com.example.demo.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MyPasswordEncode implements PasswordEncoder {
	  @Override
	    public String encode(CharSequence charSequence) {
		  System.out.println("编码后："+charSequence.toString());
	        return charSequence.toString();
	    }

	    @Override
	    public boolean matches(CharSequence charSequence, String s) {
	        return s.equals(charSequence.toString());
	    }

}
