package com.laptrinhweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhweb.conveter.JobConveter;
import com.laptrinhweb.dto.JobDTO;
import com.laptrinhweb.dto.JobHistoryDTO;
import com.laptrinhweb.entity.JobEntity;
import com.laptrinhweb.entity.JobHistoryEntity;
import com.laptrinhweb.repository.JobRepository;
import com.laptrinhweb.service.IJobService;

@Service
public class JobService implements IJobService {

	@Autowired
	public JobRepository jobRepository;
	@Autowired
	public JobConveter jobConveter;

	@Override
	public JobDTO save(JobDTO dto) {
		JobEntity entity ;
		entity = jobConveter.toEntity(dto);
		entity = jobRepository.save(entity);
		
		return jobConveter.toDTO(entity);
	}

	@Override
	public List<JobDTO> findAll() {
		List<JobEntity> listEntity = jobRepository.findAll();
		List<JobDTO> listDTO = new ArrayList<>();

		for (JobEntity item : listEntity) {
			JobDTO jobDTO = jobConveter.toDTO(item);
			listDTO.add(jobDTO);

		}
		return listDTO;
	}
}
