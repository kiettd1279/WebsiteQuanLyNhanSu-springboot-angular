package com.laptrinhweb.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
		UserEntity entity = userR.findByName(model.getName());
		if (entity == null) {
			return null;
		} else {
			if (entity.getPassword().equals(MD5(model.getPassword()))) {
					System.out.println( userC.toDTO(entity));
				return userC.toDTO(entity);
			}
			else
				return null;

		}
	}

	public String MD5(String md5) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e);
		}
		return null;
	}

}
