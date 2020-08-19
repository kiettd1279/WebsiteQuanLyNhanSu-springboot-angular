package com.laptrinhweb.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.laptrinhweb.entity.EmployeeEntity;

public class TimeKeepingDTO {
	private Long id;

	private int workTime;

	private int minimumTime;

	private int timeLate;

	private int overTime;

	private int note;

	private String dateStart;

	private String dateEnd;

	public int morning;

	public int afternoon;

	public int workDay;

	private int status;

	private EmployeeDTO employee;

	private List<TimeKeepingDetailDTO> listTKD;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getWorkTime() {
		return workTime;
	}

	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}

	public int getMinimumTime() {
		return minimumTime;
	}

	public void setMinimumTime(int minimumTime) {
		this.minimumTime = minimumTime;
	}

	public int getTimeLate() {
		return timeLate;
	}

	public void setTimeLate(int timeLate) {
		this.timeLate = timeLate;
	}

	public int getOverTime() {
		return overTime;
	}

	public void setOverTime(int overTime) {
		this.overTime = overTime;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public int getMorning() {
		return morning;
	}

	public void setMorning(int morning) {
		this.morning = morning;
	}

	public int getAfternoon() {
		return afternoon;
	}

	public void setAfternoon(int afternoon) {
		this.afternoon = afternoon;
	}

	public int getWorkDay() {
		return workDay;
	}

	public void setWorkDay(int workDay) {
		this.workDay = workDay;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public EmployeeDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}

	public List<TimeKeepingDetailDTO> getListTK() {
		return listTKD;
	}

	public void setListTK(List<TimeKeepingDetailDTO> listTKD) {
		this.listTKD = listTKD;
	}
	
}