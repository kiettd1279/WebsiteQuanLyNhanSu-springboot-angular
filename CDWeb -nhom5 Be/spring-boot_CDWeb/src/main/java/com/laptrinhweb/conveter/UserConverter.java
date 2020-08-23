package com.laptrinhweb.conveter;

import org.springframework.stereotype.Component;

import com.laptrinhweb.dto.UserDTO;
import com.laptrinhweb.entity.UserEntity;

@Component
public class UserConverter {
	public UserEntity toEntity(UserDTO dto) {
		UserEntity entity = new UserEntity();
		entity.setId(dto.getId());
		entity.setname(dto.getname());
		entity.setPassword(dto.getPassword());
		return entity;
	}

	public UserDTO toDTO(UserEntity entity) {
		UserDTO dto = new UserDTO();
		entity.setId(dto.getId());
		entity.setname(dto.getname());
		entity.setPassword(dto.getPassword());
		return dto;
	}
}
