package com.laptrinhweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhweb.dto.JobHistoryDTO;
import com.laptrinhweb.service.IJobHistoryService;

@CrossOrigin
@RestController
public class JobHistoryAPI {

	@Autowired
	private IJobHistoryService jobHService;

	@PostMapping(value = "/jobhistory")
	public JobHistoryDTO creatJH(@RequestBody JobHistoryDTO model) {
		return jobHService.save(model);
	}

	@PutMapping(value = "/jobhistory/{id}")
	public JobHistoryDTO updateJH(@RequestBody JobHistoryDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return jobHService.save(model);
	}

	@GetMapping(value = "/jobhistory")
	public List<JobHistoryDTO> getAll() {
		return jobHService.findAll();
	}
}
