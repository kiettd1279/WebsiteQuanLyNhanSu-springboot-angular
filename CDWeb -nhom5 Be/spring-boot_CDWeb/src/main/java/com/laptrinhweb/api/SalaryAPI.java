package com.laptrinhweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhweb.dto.SalaryDTO;
import com.laptrinhweb.entity.SalaryEntity;
import com.laptrinhweb.service.ISalaryService;

@CrossOrigin
@RestController
public class SalaryAPI {
	
	@Autowired
	private ISalaryService salaryService;

//	@GetMapping(value = "/salary")
//	public List<SalaryDTO> findAllSalary() {
//		return salaryService.findAll();
//	}

	@GetMapping(value = "/salary/pay")
	public List<SalaryDTO> paySalary() {
		return salaryService.paySalary();
	}
}
