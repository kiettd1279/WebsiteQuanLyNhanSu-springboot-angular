package com.laptrinhweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhweb.conveter.UserConverter;
import com.laptrinhweb.dto.UserDTO;
import com.laptrinhweb.entity.UserEntity;
import com.laptrinhweb.repository.UserRepository;
import com.laptrinhweb.service.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userR;

	@Autowired
	private UserConverter userC;

	@Override
	public UserDTO checkUser(UserDTO model) {
		UserEntity entity =null;
		try {
			 entity = userR.findByName(model.getname());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if (entity == null) {
			return null;
		} else {
			if (entity.getName().equals(model.getname())) {
				return userC.toDTO(entity);
			} else {
				UserDTO dto = new UserDTO();
				dto.setUserName(model.getname());
				dto.setPassword(null);
				return dto;
			}
		}
	}

}
