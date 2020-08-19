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

import com.laptrinhweb.dto.EmployeeDTO;
import com.laptrinhweb.entity.EmployeeEntity;
import com.laptrinhweb.service.IEmployeeService;

@CrossOrigin
@RestController
public class EmployeeAPI {

	@Autowired
	private IEmployeeService employeeServe;

	@GetMapping(value = "/employees")
	public List<EmployeeDTO> getAll() {
		return employeeServe.findAll();
	}
	
	
	@GetMapping(value = "/employee/{id}")
	public EmployeeDTO getEmployee(@PathVariable("id") long id) {
		System.out.println(id);
		return employeeServe.findOneById(id);
	}
	@PostMapping(value = "/employees")
	public EmployeeDTO craet(@RequestBody EmployeeDTO model) {
		return employeeServe.save(model);
	}
	@PutMapping(value = "/employees/{id}")
	public EmployeeDTO update(@RequestBody EmployeeDTO model, @PathVariable("id") long id) {
		model.setId(id);
	
		return employeeServe.save(model);
	}

}
