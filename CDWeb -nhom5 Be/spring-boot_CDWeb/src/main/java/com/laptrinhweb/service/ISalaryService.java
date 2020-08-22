package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.dto.SalaryDTO;
import com.laptrinhweb.entity.SalaryEntity;

public interface ISalaryService {
	//List<SalaryDTO> findAll();

	boolean checkSalary();

	List<SalaryDTO> paySalary();
	
	List<SalaryDTO> findAllSalary();
}
