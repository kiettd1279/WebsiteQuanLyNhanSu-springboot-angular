package com.laptrinhweb.conveter;

import org.springframework.stereotype.Component;

import com.laptrinhweb.dto.DeparmentDTO;
import com.laptrinhweb.entity.DeparmentEntity;

@Component
public class DeparmentConveter {
	public DeparmentDTO toDTO(DeparmentEntity entity) {
		DeparmentDTO dto = new DeparmentDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setLocationId(entity.getLocationId());
		return dto;
	}

	public DeparmentEntity toEntity(DeparmentDTO dto) {
		DeparmentEntity entity = new DeparmentEntity();
		
		entity.setLocationId(dto.getLocationId());
		entity.setName(dto.getName());
		return entity;
	}
	public DeparmentEntity toEntity(DeparmentDTO dto, DeparmentEntity entity) {
		entity.setName(dto.getName());
		entity.setLocationId(dto.getLocationId());
		return entity;
		
	}
}
