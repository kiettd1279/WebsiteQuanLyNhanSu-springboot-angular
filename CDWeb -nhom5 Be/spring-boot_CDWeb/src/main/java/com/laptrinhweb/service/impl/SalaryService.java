package com.laptrinhweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhweb.conveter.EmployeeConveter;
import com.laptrinhweb.conveter.SalaryConverter;
import com.laptrinhweb.dto.SalaryDTO;
import com.laptrinhweb.entity.EmployeeEntity;
import com.laptrinhweb.entity.InsurranceEntity;
import com.laptrinhweb.entity.SalaryEntity;
import com.laptrinhweb.entity.TaxEntity;
import com.laptrinhweb.entity.TimeKeepingEntity;
import com.laptrinhweb.repository.InsurranceRepository;
import com.laptrinhweb.repository.SalaryRepository;
import com.laptrinhweb.repository.TaxReposiotry;
import com.laptrinhweb.repository.TimeKeepingRepository;
import com.laptrinhweb.service.ISalaryService;

@Service
public class SalaryService implements ISalaryService {
	@Autowired
	private SalaryConverter salaryConverter;

	@Autowired
	private SalaryRepository salaryReposiotry;

	@Autowired
	private TimeKeepingRepository timekeepingReposotry;

	@Autowired
	private InsurranceRepository insurranceRepository;

	@Autowired
	private TaxReposiotry taxRepository;

	@Autowired
	EmployeeConveter employeeConverter;

	@Override
	public List<SalaryDTO> findAllSalary() {
		List<SalaryEntity> entitis = salaryReposiotry.findAll();

		System.out.println(entitis.size());
		
		List<SalaryDTO> dtos = new ArrayList<SalaryDTO>();
		for (SalaryEntity item : entitis) {

			SalaryDTO dto = salaryConverter.toDTO(item);
			dto.setEmployee(employeeConverter.toDTO(item.getEmployee()));
			dtos.add(dto);
		}
		return dtos;
	}
//	@Override
//	public List<SalaryDTO> findAllSalary() {
//		
//	}

	@Override
	public boolean checkSalary() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SalaryDTO> paySalary() {
		List<TimeKeepingEntity> listTimeKeeping = timekeepingReposotry.findByStatus(0);
		System.out.println(listTimeKeeping.size());
		List<SalaryDTO> dtos = new ArrayList<SalaryDTO>();
		List<SalaryEntity> entitis = new ArrayList<SalaryEntity>();

		if (listTimeKeeping.size() == 0 || listTimeKeeping == null) {
			return null;
		}
		if (listTimeKeeping.size() > 0) {

			// lấy tiền bảo hiểm
			List<InsurranceEntity> listInsurance = insurranceRepository.findAll();
			int insurrance = payInsurrance(listInsurance);

			for (TimeKeepingEntity item : listTimeKeeping) {
				item.setStatus(2);
				EmployeeEntity employee = item.getEmployee();
				// tính tiền thuế
				List<TaxEntity> listTax = taxRepository.findAll();
				int tax = payTex(listTax, employee.getSalary());
				int dayWorking = item.getWorkDay();
				int mininmumDayWorking = 30;
				int rewardMoney = 0;
				int publishMoney = employee.getSalary() - rewardMoney - tax - insurrance;
				SalaryEntity entity = new SalaryEntity(item.getDateEnd(), dayWorking, tax, 0, publishMoney, insurrance,
						employee.getSalary(), true);
				entity.setEmployee(employee);

				entitis.add(entity);
				SalaryDTO dto = salaryConverter.toDTO(entity);
				dto.setEmployee(employeeConverter.toDTO(employee));
				dtos.add(dto);
			}
			timekeepingReposotry.save(listTimeKeeping);
		}

		salaryReposiotry.save(entitis);
		return dtos;
	}

	// phương thức tính tất cả khoản bảo hiểm
	public int payInsurrance(List<InsurranceEntity> list) {
		int pay = 0;
		for (InsurranceEntity item : list) {
			pay += item.getInsRatio();
		}
		return pay;
	}

	// 10000000
	// 10000000
	public int payTex(List<TaxEntity> listTax, int salary) {

		if (salary <= listTax.get(0).getMaxIncome()) {
			return (int) (salary * 0.01);
		}
		if (salary >= listTax.get(listTax.size() - 1).getMaxIncome()) {
			return (int) (salary * listTax.get(listTax.size() - 1).getRatio());
		}

		for (int i = 0; i < listTax.size() - 1; i++) {
			if (salary >= listTax.get(i).getMaxIncome() && salary < listTax.get(i + 1).getMaxIncome()) {

				return (int) (salary * listTax.get(i).getRatio());
			}
		}
		return 0;
	}

}
