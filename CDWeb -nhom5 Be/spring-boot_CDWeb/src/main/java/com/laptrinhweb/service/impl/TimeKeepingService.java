package com.laptrinhweb.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhweb.conveter.EmployeeConveter;
import com.laptrinhweb.conveter.TimeKeepingConveter;
import com.laptrinhweb.dto.DateTime;
import com.laptrinhweb.dto.EmployeeDTO;
import com.laptrinhweb.dto.TimeKeepingDTO;
import com.laptrinhweb.dto.TimeKeepingInforDTO;
import com.laptrinhweb.entity.EmployeeEntity;
import com.laptrinhweb.entity.TimeKeepingDetailEntity;
import com.laptrinhweb.entity.TimeKeepingEntity;
import com.laptrinhweb.repository.EmployeeRepository;
import com.laptrinhweb.repository.TimeKeepingDetailRepository;
import com.laptrinhweb.repository.TimeKeepingRepository;
import com.laptrinhweb.service.ITimeKeepingService;

@Service
public class TimeKeepingService implements ITimeKeepingService {

	@Autowired
	private EmployeeRepository employeeReposiotry;

	@Autowired
	private TimeKeepingRepository timeKeepingRepository;

	@Autowired
	private TimeKeepingConveter timeKeepingConveter;

	@Autowired
	private TimeKeepingDetailRepository timeKeepingDetailRepository;

	@Autowired
	private EmployeeConveter empConveter;

	// tạo bảng lương với tất cả danh sách nhân viên
	// nếu thời gian hiện tại(nowDate) < startDate -20; + chấm công
	// nếu thời gian hiện tại(nowDate) > startDate -20; + tạo ra bảng lương mới
	/*
	 * Status 1:Chấm công Status 0:Chốt bảng công Status 2: đã trả lương
	 */
	
	// tao bang chấm công từ danh sahcs nhân viên
	@Override
	public List<TimeKeepingDTO> saveAll() {
		List<TimeKeepingEntity> listoldTimeKeeping = timeKeepingRepository.findByStatus(1);

		if (listoldTimeKeeping.size() <= 0 || listoldTimeKeeping == null) {
			List<TimeKeepingEntity> newListTimKeeping = new ArrayList<TimeKeepingEntity>();
			List<EmployeeEntity> listEmployeeEntity = employeeReposiotry.findAll();
			List<TimeKeepingDTO> listDTO = new ArrayList<TimeKeepingDTO>();
			// lấy ngày hiện tại ra kiểm tra
			Calendar c = Calendar.getInstance();
			DateTime date = new DateTime();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);
			date.setDateTime(hour, minute, day, hour, year);
			String time = date.format();
			System.out.println(listEmployeeEntity.size());
			for (EmployeeEntity item : listEmployeeEntity) {
				TimeKeepingEntity t = new TimeKeepingEntity();

				t.setDateStart(time);
				t.setEmployee(item);
				t.setMinimumTime(6);
				t.setStatus(1);
				t.setAfternoon(1);
				t.setMorning(1);

				newListTimKeeping.add(t);
				listDTO.add(timeKeepingConveter.toDTO(t));
				// timeKeepingRepository.save(newListTimKeeping);

			}
			timeKeepingRepository.save(newListTimKeeping);
			return listDTO;
		}
		return null;

	}

	@Override
	public List<TimeKeepingDTO> findAll() {
		List<TimeKeepingEntity> listEntity = timeKeepingRepository.findByStatus(0);
		List<TimeKeepingDTO> listDTO = new ArrayList<TimeKeepingDTO>();
		for (TimeKeepingEntity item : listEntity) {

			TimeKeepingDTO dto = timeKeepingConveter.toDTO(item);
			EmployeeDTO emp = empConveter.toDTO(item.getEmployee());
			dto.setEmployee(emp);
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public TimeKeepingDTO edit(TimeKeepingDTO model) {

		return null;
	}

	@Override
	public TimeKeepingDTO update(TimeKeepingDTO model) {

		// TimeKeepingEntity oldEntity = timeKeepingRepository.findOne(model.getId());

//		TimeKeepingEntity entity = timeKeepingConveter.toEntity(oldEntity, model);
//		System.out.println(entity.getWorkTime() +"new");
//		System.out.println(oldEntity.getWorkTime() +"old");
//
//		entity.plusWorkTime();
//		entity = timeKeepingRepository.save(entity);

		return null;
	}

	@Override
	public TimeKeepingDTO findByOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeKeepingDTO> FindAll() {
		List<TimeKeepingEntity> listEntity = timeKeepingRepository.findAll();
		List<TimeKeepingDTO> listDTO = new ArrayList<TimeKeepingDTO>();

		for (TimeKeepingEntity item : listEntity) {
			TimeKeepingDTO dto = timeKeepingConveter.toDTO(item);
			listDTO.add(dto);
		}
		return listDTO;

	}

	@Override
	public List<TimeKeepingDTO> findMorning() {

		List<TimeKeepingEntity> listEntity = timeKeepingRepository.findByMorning(1);
		List<TimeKeepingDTO> listDTO = new ArrayList<TimeKeepingDTO>();

		for (TimeKeepingEntity item : listEntity) {
			TimeKeepingDTO dto = timeKeepingConveter.toDTO(item);
			EmployeeDTO emp = empConveter.toDTO(item.getEmployee());
			dto.setEmployee(emp);
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public List<TimeKeepingDTO> findAfternoon() {
		List<TimeKeepingEntity> listEntity = timeKeepingRepository.findByAfternoon(1);
		List<TimeKeepingDTO> listDTO = new ArrayList<TimeKeepingDTO>();

		for (TimeKeepingEntity item : listEntity) {
			TimeKeepingDTO dto = timeKeepingConveter.toDTO(item);
			EmployeeDTO emp = empConveter.toDTO(item.getEmployee());
			dto.setEmployee(emp);
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public TimeKeepingDTO stardUp(TimeKeepingDTO model, String shift) {
		Calendar c = Calendar.getInstance();
		DateTime date = new DateTime();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		date.setDateTime(hour, minute, day, hour, year);
		String time = date.format();

		TimeKeepingEntity oldentity = timeKeepingRepository.findOne(model.getId());

		TimeKeepingDetailEntity tkd = new TimeKeepingDetailEntity(time, shift, oldentity);
		tkd.setEmployee(oldentity.getEmployee());
		tkd = timeKeepingDetailRepository.save(tkd);
		if (shift.equals("morning")) {
			oldentity.setMorning(0);
		}
		if (shift.equals("afternoon")) {
			oldentity.setAfternoon(0);
		}

		oldentity = timeKeepingRepository.save(oldentity);
		return timeKeepingConveter.toDTO(oldentity);
	}

	@Override
	public List<TimeKeepingDTO> RefetTimeKeeping() {
		List<TimeKeepingEntity> listEntity = timeKeepingRepository.findByStatus(1);
		List<TimeKeepingDTO> dtos = new ArrayList<TimeKeepingDTO>();
		List<TimeKeepingEntity> listMorning = timeKeepingRepository.findByMorning(1);
		List<TimeKeepingEntity> listAfter = timeKeepingRepository.findByMorning(1);
		if (listEntity.size() <= 0 || listEntity == null || listMorning != null || listAfter != null) {
			System.out.println("ko thẻ refect" + listEntity.size());
			return null;
		}
		for (TimeKeepingEntity item : listEntity) {
			item.setMorning(1);
			item.setAfternoon(1);
			dtos.add(timeKeepingConveter.toDTO(item));
		}
		timeKeepingRepository.save(listEntity);
		return dtos;
	}

	@Override
	public List<TimeKeepingDTO> CloseTimeKeeping() {
		List<TimeKeepingEntity> listEntity = timeKeepingRepository.findByStatus(1);
		List<TimeKeepingDTO> listDTO = new ArrayList<TimeKeepingDTO>();
		if (listEntity.size() <= 0) {
			return null;
		}
		for (TimeKeepingEntity item : listEntity) {
			item.setStatus(0);
			item.setAfternoon(0);
			item.setMorning(0);
			listDTO.add(timeKeepingConveter.toDTO(item));
		}
		timeKeepingRepository.save(listEntity);
		return listDTO;
	}

	@Override
	public List<String> search() {
		List<TimeKeepingEntity> listEntity = timeKeepingRepository.findByStatus(1);
		List<String> list = new ArrayList<String>();
		for (TimeKeepingEntity item : listEntity) {
			list.add(item.getEmployee().getFirstName());
		}
	return list;
	}

	@Override
	public List<TimeKeepingDTO> listsearch(String text) {
		List<TimeKeepingEntity> listEntity =null;
		if (text.equals("")|| text =="") {
			listEntity = timeKeepingRepository.findByStatus(1);
		}else {
			listEntity= timeKeepingRepository.findByEmployeeFirstName(text);
		}
		List<TimeKeepingDTO> listDTO = new ArrayList<TimeKeepingDTO>();
		for (TimeKeepingEntity item : listEntity) {
			TimeKeepingDTO dto = timeKeepingConveter.toDTO(item);
			dto.setEmployee(empConveter.toDTO(item.getEmployee()));
			listDTO.add(dto);
		}
		return listDTO;
	}
}
