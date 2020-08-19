package com.laptrinhweb.conveter;

import org.springframework.stereotype.Component;

import com.laptrinhweb.dto.JobDTO;
import com.laptrinhweb.entity.JobEntity;

@Component
public class JobConveter {

	public JobEntity toEntity(JobDTO dto) {
		JobEntity entity = new JobEntity();
		entity.setTitle(dto.getTitle());
		entity.setMaxSalary(dto.getMaxSalary());
		entity.setMinSalary(dto.getMinSalary());
		entity.setCode(dto.getCode());
		return entity;
	}

	public JobDTO toDTO(JobEntity entity) {
		JobDTO dto = new JobDTO();
		dto.setTitle(entity.getTitle());
		dto.setMaxSalary(entity.getMaxSalary());
		dto.setMinSalary(entity.getMinSalary());
		dto.setCode(entity.getCode());
		return dto;
	}
}
