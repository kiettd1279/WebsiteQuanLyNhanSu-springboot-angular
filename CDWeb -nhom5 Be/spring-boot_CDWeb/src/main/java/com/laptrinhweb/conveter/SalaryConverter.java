package com.laptrinhweb.conveter;

import org.springframework.stereotype.Component;

import com.laptrinhweb.dto.SalaryDTO;
import com.laptrinhweb.entity.SalaryEntity;

@Component
public class SalaryConverter {
	public SalaryDTO toDTO(SalaryEntity entity) {
		SalaryDTO dto = new SalaryDTO();
		dto.setId(entity.getId());
		dto.setCountedDate(entity.getCountedDate());
		dto.setInsurranceMoney(entity.getInsurranceMoney());
		dto.setTaxMoney(entity.getTaxMoney());
		dto.setWorkDay(entity.getWorkDay());
		dto.setRewardMoney(entity.getRewardMoney());
		dto.setSalary(entity.getSalary());
		dto.setPublishMoney(entity.getPublishMoney());
		return dto;
		
	}
}
