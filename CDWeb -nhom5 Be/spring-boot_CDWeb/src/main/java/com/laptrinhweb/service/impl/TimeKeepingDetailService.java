package com.laptrinhweb.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhweb.conveter.EmployeeConveter;
import com.laptrinhweb.conveter.TimeKeepingConveter;
import com.laptrinhweb.conveter.TimeKeepingKeepingDetailConveter;
import com.laptrinhweb.dto.DateTime;
import com.laptrinhweb.dto.EmployeeDTO;
import com.laptrinhweb.dto.TimeKeepingDTO;
import com.laptrinhweb.dto.TimeKeepingDetailDTO;
import com.laptrinhweb.entity.TimeKeepingDetailEntity;
import com.laptrinhweb.entity.TimeKeepingEntity;
import com.laptrinhweb.repository.TimeKeepingDetailRepository;
import com.laptrinhweb.repository.TimeKeepingRepository;
import com.laptrinhweb.service.ITimeKeepingDetailService;

@Service
public class TimeKeepingDetailService implements ITimeKeepingDetailService {

	@Autowired
	private TimeKeepingDetailRepository timeKeepingDetailRepostory;

	@Autowired
	private TimeKeepingKeepingDetailConveter timeKeepingDetailConveter;

	@Autowired
	private TimeKeepingRepository timeKeepingRepository;

	@Autowired
	private TimeKeepingConveter timeKeepingConveter;

	@Autowired
	private EmployeeConveter employeeConveter;

	@Override
	public List<TimeKeepingDetailDTO> findAllHistory() {
		List<TimeKeepingDetailEntity> listEntity = timeKeepingDetailRepostory.findAll();
		List<TimeKeepingDetailDTO> listDTO = new ArrayList<TimeKeepingDetailDTO>();
		System.out.println(listEntity.size());
		for (int i = listEntity.size() - 1; i >= 0; i--) {
			TimeKeepingDetailDTO dto = timeKeepingDetailConveter.toDTO(listEntity.get(i));
			dto.setEmployee(employeeConveter.toDTO(listEntity.get(i).getEmployee()));
			listDTO.add(dto);
		}
		
		return listDTO;
	}

	@Override
	public TimeKeepingDetailDTO endTimeKeepingforOneDay(TimeKeepingDetailDTO model) {
		TimeKeepingDetailEntity oldEntity = timeKeepingDetailRepostory.findOne(model.Id);
		oldEntity.setStatus(0);

		Calendar c = Calendar.getInstance();
		DateTime date = new DateTime();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		date.setDateTime(hour, minute, day, hour, year);

		DateTime olddate = new DateTime();
		olddate.setDate(oldEntity.getTimeStart());
		int workingDay = date.subtractHours(date.getTime(), olddate.getTime());
		// System.out.println(workingDay +" start " +date.getTime() +" old :"
		// +olddate.getTime());
		oldEntity.setTimeWorking(workingDay);
		oldEntity.setTimeEnd(date.format());
		TimeKeepingEntity tkEntity = oldEntity.getTimeKeeping();
		tkEntity.plusWorkTime(workingDay);
		timeKeepingRepository.save(tkEntity);

		oldEntity = timeKeepingDetailRepostory.save(oldEntity);
		TimeKeepingDetailDTO dto = timeKeepingDetailConveter.toDTO(oldEntity);
		return dto;
	}

	@Override
	public TimeKeepingDetailDTO removeTimeKeeping(long id) {
		TimeKeepingDetailEntity entity = timeKeepingDetailRepostory.findOne(id);
		timeKeepingDetailRepostory.delete(id);
		return timeKeepingDetailConveter.toDTO(entity);
	}

	@Override
	public List<TimeKeepingDetailDTO> findAllShift(String shift) {
		List<TimeKeepingDetailEntity> listTKD = timeKeepingDetailRepostory.findByStatus(1);
		List<TimeKeepingDetailDTO> listDTO = new ArrayList<TimeKeepingDetailDTO>();

		for (TimeKeepingDetailEntity item : listTKD) {
			if (item.getShift().equals(shift)) {

				TimeKeepingDetailDTO dto = timeKeepingDetailConveter.toDTO(item);
				TimeKeepingDTO timeKeepingDTO = timeKeepingConveter.toDTO(item.getTimeKeeping());
				EmployeeDTO employeeDTO = employeeConveter.toDTO(item.getTimeKeeping().getEmployee());

				timeKeepingDTO.setEmployee(new EmployeeDTO());
				dto.setTimeKeeping(timeKeepingDTO);

				listDTO.add(dto);
			}

		}
		return listDTO;
	}

}
