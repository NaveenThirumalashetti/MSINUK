package com.msinuk.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msinuk.main.model.LoginResponse;
import com.msinuk.main.model.UserDTO;
import com.msinuk.main.service.UserService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/")
public class UserController {
	
	@Autowired
	private UserService service;


	@PostMapping("/addUser")
	public LoginResponse addUser(@RequestBody UserDTO user){
		return this.service.addUser(user);
	}
	
	@GetMapping("/user")
	public LoginResponse getUser(@RequestParam("username") String username,@RequestParam("password") String password) {
		return this.service.getUser(username,password);
	}

}
