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

<<<<<<< HEAD
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
=======

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
>>>>>>> c3e4997b87ea101a295e9aa99b7b4f54abba1794
		}
		return null;
	}

}
