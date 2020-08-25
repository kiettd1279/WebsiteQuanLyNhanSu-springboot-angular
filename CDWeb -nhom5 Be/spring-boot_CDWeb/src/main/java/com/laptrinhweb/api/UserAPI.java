package com.laptrinhweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhweb.dto.UserDTO;
import com.laptrinhweb.service.IUserService;

@CrossOrigin
@RestController
public class UserAPI {
	@Autowired
	private IUserService userService;

	@PostMapping(value = "/user")
<<<<<<< HEAD
	public UserDTO check( @RequestBody UserDTO model) {
		UserDTO dto = userService.checkUser(model);
		System.out.println(dto.getname());
	return	dto;
=======
	public ResponseEntity<UserDTO> check(@RequestBody UserDTO model) {
		UserDTO result = userService.checkUser(model);
		if(result==null)
		return new ResponseEntity<UserDTO>(result, HttpStatus.UNAUTHORIZED);

		return new ResponseEntity<UserDTO>(result, HttpStatus.OK);

>>>>>>> c3e4997b87ea101a295e9aa99b7b4f54abba1794
	}
}
