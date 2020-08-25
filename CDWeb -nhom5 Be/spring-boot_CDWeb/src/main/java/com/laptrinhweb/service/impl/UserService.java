package com.laptrinhweb.service.impl;

import java.security.MessageDigest;

import org.apache.tomcat.util.security.MD5Encoder;
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

	private MD5Encoder md5;

	@Override
	public UserDTO checkUser(UserDTO model) {
		UserEntity entity = userR.findByName(model.getname());
		if (entity == null) {
			return null;
		} else {
//			this.md5.encode(binaryData)
//			if()

			return userC.toDTO(entity);
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
		}
		return null;
	}

	public static void main(String[] args) {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] thedigest = md.digest(bytesOfMessage);
	}

}
