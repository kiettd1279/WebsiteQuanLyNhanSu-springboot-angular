package com.laptrinhweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhweb.conveter.DeparmentConveter;
import com.laptrinhweb.conveter.EmployeeConveter;
import com.laptrinhweb.dto.DeparmentDTO;
import com.laptrinhweb.entity.DeparmentEntity;
import com.laptrinhweb.entity.EmployeeEntity;
import com.laptrinhweb.repository.DepartmentRepository;
import com.laptrinhweb.service.IDeparmentService;

@Service
public class DeparmentService implements IDeparmentService {

	@Autowired
	private DepartmentRepository departmanetReposiotry;
	
	@Autowired 
	private DeparmentConveter departmentConverter;
	
	@Autowired
	private EmployeeConveter employeeConverter;
	
	@Override
	public List<DeparmentDTO> findAll() {
		List<DeparmentEntity> listEntity = departmanetReposiotry.findAll();
		List<DeparmentDTO> listDTO = new ArrayList<DeparmentDTO>();
		for (DeparmentEntity item : listEntity) {
			DeparmentDTO dto = departmentConverter.toDTO(item);
			List<EmployeeEntity> listEntityEmployee = item.getEmployeees();
			for (EmployeeEntity itemEmployee : listEntityEmployee) {
				dto.getEmployeees().add(employeeConverter.toDTO(itemEmployee));
			}
			
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public DeparmentDTO save(DeparmentDTO dto) {
		DeparmentEntity newEntity ;
		
		if (dto.getId() != null) {
			DeparmentEntity oldEntity = departmanetReposiotry.findOne(dto.getId());
			newEntity = departmentConverter.toEntity(dto, oldEntity);
			
		}else {
			newEntity = departmentConverter.toEntity(dto);
		}
		newEntity = departmanetReposiotry.save(newEntity);
		
		return departmentConverter.toDTO(newEntity);
	}

}
