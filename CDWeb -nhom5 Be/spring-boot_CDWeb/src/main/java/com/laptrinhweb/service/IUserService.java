package com.laptrinhweb.service;

import com.laptrinhweb.dto.UserDTO;
import com.laptrinhweb.entity.UserEntity;

public interface IUserService {
	UserDTO checkUser(UserDTO model);
}
