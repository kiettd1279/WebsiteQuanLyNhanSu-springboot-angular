package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.dto.EmployeeDTO;

public interface IEmployeeService {
	EmployeeDTO save(EmployeeDTO dto);
	List<EmployeeDTO> findAll();
	EmployeeDTO findOneById(Long id);
}
