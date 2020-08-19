package com.laptrinhweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhweb.conveter.EmployeeConveter;
import com.laptrinhweb.conveter.JobHistoryConveter;
import com.laptrinhweb.dto.EmployeeDTO;
import com.laptrinhweb.dto.JobHistoryDTO;
import com.laptrinhweb.entity.EmployeeEntity;
import com.laptrinhweb.entity.JobHistoryEntity;
import com.laptrinhweb.repository.EmployeeRepository;
import com.laptrinhweb.repository.JobHistoryRepository;
import com.laptrinhweb.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired 
	private EmployeeConveter employeeConveter;
	
	@Autowired JobHistoryConveter jHConveter;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public EmployeeDTO save(EmployeeDTO dto) {
		EmployeeEntity entity ;
		if (dto.getId()!=null) {
			EmployeeEntity oldEntity = employeeRepository.findOne(dto.getId());
			entity = employeeConveter.toEntity(oldEntity, dto);
		}else {
			entity = employeeConveter.toEntity(dto);
		}
		entity = employeeRepository.save(entity);
		return employeeConveter.toDTO(entity);
	}

	@Override
	public List<EmployeeDTO> findAll() {
	List<EmployeeEntity> listEntity = employeeRepository.findAll();
	List<EmployeeDTO> listDTO = new ArrayList<EmployeeDTO>();
	for (EmployeeEntity item : listEntity) {
		List<JobHistoryEntity> listJobHistoryEntity =item.getJobHistory();
		EmployeeDTO dto = employeeConveter.toDTO(item);
		for (JobHistoryEntity itemJHEntity : listJobHistoryEntity) {
			JobHistoryDTO dtoJobH = jHConveter.toDTO(itemJHEntity);
			dto.getListJH().add(dtoJobH);
		}
		listDTO.add(dto);	
	}
	
		return listDTO;
	}

	@Override
	public EmployeeDTO findOneById(Long id) {
		EmployeeEntity entity = employeeRepository.findOne(id);
		return employeeConveter.toDTO(entity);
	}
	
}
