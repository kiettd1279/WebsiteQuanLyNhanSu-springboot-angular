package com.laptrinhweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhweb.dto.TimeKeepingDTO;
import com.laptrinhweb.dto.UserDTO;
import com.laptrinhweb.service.IUserService;

@CrossOrigin
@RestController
public class UserAPI {
	@Autowired
	private IUserService userService;
	
	@PostMapping(value = "/user")
	public UserDTO check( @RequestBody UserDTO model) {
	return	userService.checkUser(model);
	}
}
