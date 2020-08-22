package com.laptrinhweb.conveter;

import org.springframework.stereotype.Component;

import com.laptrinhweb.dto.CandidateDTO;
import com.laptrinhweb.entity.CandidateEntity;

@Component
public class CandidateConveter {
	public CandidateDTO toDTO(CandidateEntity entity) {
		CandidateDTO dto = new CandidateDTO();
		dto.setId(entity.getId());
		dto.setFirstname(entity.getFirstname());
		dto.setLastname(entity.getLastname());
		dto.setBirthDay(entity.getBirthDay());
		dto.setGender(entity.getGender());
		dto.setEmail(entity.getEmail());
		dto.setPhoneNumber(entity.getPhoneNumber());
		dto.setImageName(entity.getImageName());
		dto.setEthnic(entity.getEthnic());
		dto.setHometown(entity.getHometown());
		dto.setIDCard(entity.getIDCard());
		dto.setDegree(entity.getDegree());
		dto.setCareer(entity.getCareer());
		dto.setExperience(entity.getExperience());
		dto.setLiteracy(entity.getLiteracy());
		dto.setSkill(entity.getSkill());
		dto.setHobby(entity.getHobby());
		dto.setPosition(entity.getPosition());
		dto.setStatus(entity.getStatus());
		return dto;
	}
	
	public CandidateEntity toEntity(CandidateDTO dto) {
		CandidateEntity entity = new CandidateEntity();
		entity.setId(dto.getId());
		entity.setFirstname(dto.getFirstname());
		entity.setLastname(dto.getLastname());
		entity.setBirthDay(dto.getBirthDay());
		entity.setGender(dto.getGender());
		entity.setEmail(dto.getEmail());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setImageName(dto.getImageName());
		entity.setEthnic(dto.getEthnic());
		entity.setHometown(dto.getHometown());
		entity.setIDCard(dto.getIDCard());
		entity.setDegree(dto.getDegree());
		entity.setCareer(dto.getCareer());
		entity.setExperience(dto.getExperience());
		entity.setLiteracy(dto.getLiteracy());
		entity.setSkill(dto.getSkill());
		entity.setHobby(dto.getHobby());
		entity.setPosition(dto.getPosition());
		entity.setStatus(dto.getStatus());
		return entity;
	}
	
	public CandidateEntity toEntity(CandidateEntity entity,CandidateDTO dto) {
		entity.setId(dto.getId());
		entity.setFirstname(dto.getFirstname());
		entity.setLastname(dto.getLastname());
		entity.setBirthDay(dto.getBirthDay());
		entity.setGender(dto.getGender());
		entity.setEmail(dto.getEmail());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setImageName(dto.getImageName());
		entity.setEthnic(dto.getEthnic());
		entity.setHometown(dto.getHometown());
		entity.setIDCard(dto.getIDCard());
		entity.setDegree(dto.getDegree());
		entity.setCareer(dto.getCareer());
		entity.setExperience(dto.getExperience());
		entity.setLiteracy(dto.getLiteracy());
		entity.setSkill(dto.getSkill());
		entity.setHobby(dto.getHobby());
		entity.setPosition(dto.getPosition());
		entity.setStatus(dto.getStatus());
		return entity;
	}
}
