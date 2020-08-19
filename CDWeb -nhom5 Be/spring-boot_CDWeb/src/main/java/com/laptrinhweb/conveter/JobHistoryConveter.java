package com.laptrinhweb.conveter;

import org.springframework.stereotype.Component;

import com.laptrinhweb.dto.JobHistoryDTO;
import com.laptrinhweb.entity.JobHistoryEntity;

@Component
public class JobHistoryConveter {
	public JobHistoryEntity toEntity(JobHistoryDTO jobHistoryDTO) {
		JobHistoryEntity entity = new JobHistoryEntity();
		entity.setStartDate(jobHistoryDTO.getStartDate());
		entity.setEndDate(jobHistoryDTO.getEndDate());
		
		return entity;
	}

	public JobHistoryDTO toDTO(JobHistoryEntity entity) {
		JobHistoryDTO dto = new JobHistoryDTO();
		dto.setStartDate(entity.getStartDate());
		dto.setEndDate(entity.getEndDate());
		dto.setJobId(entity.getJob().getCode());
		return dto;
	}
	public JobHistoryEntity toEntity(JobHistoryDTO jobHistoryDTO,JobHistoryEntity jobHEntity) {
		jobHEntity.setStartDate(jobHistoryDTO.getStartDate());
		jobHEntity.setEndDate(jobHistoryDTO.getEndDate());
		return jobHEntity;
	}

}
