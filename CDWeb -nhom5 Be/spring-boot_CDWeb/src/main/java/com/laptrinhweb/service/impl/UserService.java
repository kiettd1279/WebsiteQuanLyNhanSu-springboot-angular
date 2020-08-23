package com.laptrinhweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhweb.conveter.UserConverter;
import com.laptrinhweb.dto.UserDTO;
import com.laptrinhweb.entity.UserEntity;
import com.laptrinhweb.repository.UserRepository;
import com.laptrinhweb.service.IUserService;

@Service
public class UserService implements IUserService{
	@Autowired
	private UserRepository userR;
	
	@Autowired 
	private UserConverter userC;
	
	@Override
	public UserDTO checkUser(UserDTO model) {
		UserEntity entity = userR.findByName(model.getname());
		if (entity == null) {
			return null;
		}else {
			return userC.toDTO(entity);
		}
	}

}
