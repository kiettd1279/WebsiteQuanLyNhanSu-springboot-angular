package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.dto.JobDTO;

public interface IJobService {
	JobDTO save(JobDTO dto);
	List<JobDTO> findAll();
}
