package com.laptrinhweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhweb.conveter.JobHistoryConveter;
import com.laptrinhweb.dto.JobHistoryDTO;
import com.laptrinhweb.entity.JobEntity;
import com.laptrinhweb.entity.JobHistoryEntity;
import com.laptrinhweb.repository.JobHistoryRepository;
import com.laptrinhweb.repository.JobRepository;
import com.laptrinhweb.service.IJobHistoryService;

@Service
public class JobHistoryService implements IJobHistoryService {

	@Autowired
	private JobHistoryRepository jobHistoryRepostory;
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private JobHistoryConveter jobHConveter;

	@Override
	public JobHistoryDTO save(JobHistoryDTO jobHistoryDTO) {

		JobHistoryEntity jobHEntity;

		if (jobHistoryDTO.getId() != null) {
			JobHistoryEntity oldJH = jobHistoryRepostory.findOne(jobHistoryDTO.getId());
			jobHEntity  = jobHConveter.toEntity(jobHistoryDTO, oldJH);
		} else {
			jobHEntity = jobHConveter.toEntity(jobHistoryDTO);
		}

		JobEntity jobEntity = jobRepository.findOneByCode(jobHistoryDTO.getJobId());
		jobHEntity.setJob(jobEntity);
		jobHEntity = jobHistoryRepostory.save(jobHEntity);
		return jobHConveter.toDTO(jobHEntity);
	}

	@Override
	public List<JobHistoryDTO> findAll() {
		List<JobHistoryEntity> listEntity = jobHistoryRepostory.findAll();
		List<JobHistoryDTO> listDTO = new ArrayList<>();
		for (JobHistoryEntity item : listEntity) {
			JobHistoryDTO jhDTO = jobHConveter.toDTO(item);
			listDTO.add(jhDTO);
		}
		return listDTO;
	}
}
