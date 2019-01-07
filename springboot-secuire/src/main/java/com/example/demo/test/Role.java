package com.example.demo.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Role {
	@Id
//	@GenericGenerator(name="generator",strategy="uuid.hex")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
//	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "roles")
	@ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
//	@ManyToMany(mappedBy = "roles")
	private Set<MyUser> users=new HashSet<>();
	public Set<MyUser> getUsers() {
		return users;
	}
	public void setUsers(Set<MyUser> users) {
		this.users = users;
	}
	public Role(String name){
		this.name=name;
	}
	public Role(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", users=" + users + "]";
	}
	
}
