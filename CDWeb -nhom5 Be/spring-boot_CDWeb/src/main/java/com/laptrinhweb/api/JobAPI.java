package com.laptrinhweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhweb.dto.JobDTO;
import com.laptrinhweb.service.IJobService;

@CrossOrigin
@RestController
public class JobAPI {
	@Autowired
	private IJobService jobService ;
	
	@GetMapping(value = "/job")
	public List<JobDTO> getAll() {
		return jobService.findAll();
	}
	@PostMapping(value = "/job")
	public JobDTO creat(@RequestBody JobDTO model) {
		return jobService.save(model);
	}
}
