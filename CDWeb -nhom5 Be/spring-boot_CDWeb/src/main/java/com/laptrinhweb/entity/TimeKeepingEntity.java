package com.laptrinhweb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "timeKeeping")
public class TimeKeepingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private int workTime;

	@Column
	private int minimumTime;

	@Column
	private int timeLate;

	@Column
	private int overTime;

	@Column
	private int note;

	@Column
	private String dateStart;

	@Column
	private String dateEnd;

	@Column
	public int morning;

	@Column
	public int afternoon;

	@Column
	public int workDay;

	@Column
	private int status;
	
	

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private EmployeeEntity employee;

	@OneToMany(mappedBy = "timeKeeping")
	private List<TimeKeepingDetailEntity> listTimeKeeping = new ArrayList<TimeKeepingDetailEntity>();

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
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

	public List<TimeKeepingDetailEntity> getJobHistory() {
		return listTimeKeeping;
	}

	public void setJobHistory(List<TimeKeepingDetailEntity> listTimeKeeping) {
		this.listTimeKeeping = listTimeKeeping;
	}

	public void plusWorkTime(int timeWorking) {
		this.workTime += timeWorking;
	}
}
