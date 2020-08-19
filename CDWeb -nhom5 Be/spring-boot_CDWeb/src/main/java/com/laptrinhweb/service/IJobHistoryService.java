package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.dto.JobHistoryDTO;

public interface IJobHistoryService {
	JobHistoryDTO save(JobHistoryDTO jobHistoryDTO);
	List<JobHistoryDTO> findAll();
}
