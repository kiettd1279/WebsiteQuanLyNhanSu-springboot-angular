package com.laptrinhweb.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import com.laptrinhweb.entity.EmployeeEntity;

public class DeparmentDTO {
	
	private Long id;
	
	private String name;

	private String locationId;
	
	List<EmployeeDTO> employeees =new ArrayList<EmployeeDTO>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public List<EmployeeDTO> getEmployeees() {
		return employeees;
	}

	public void setEmployeees(List<EmployeeDTO> employeees) {
		this.employeees = employeees;
	}
	
}
