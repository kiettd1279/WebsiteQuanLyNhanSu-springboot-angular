package com.laptrinhweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "timeKeepingDetail")
public class TimeKeepingDetailEntity {
	
	public TimeKeepingDetailEntity() {
		super();
	}

	public TimeKeepingDetailEntity(String timeStart, String shift,TimeKeepingEntity timeKeeping) {
		super();

		this.timeStart = timeStart;
		this.timeWorking = 0;
		this.shift = shift;
		this.status = 1;
		this.timeKeeping = timeKeeping;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	@Column
	private String timeStart;

	@Column
	private String timeEnd;

	@Column
	private int timeWorking;

	@Column
	private String shift;

	@Column
	private int status;
	
	@ManyToOne
	@JoinColumn(name = "TimeKeepingId")
	private TimeKeepingEntity timeKeeping;

	@ManyToOne
	@JoinColumn(name = "EmployeeId")
	private EmployeeEntity employee;

	
	
	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public int getTimeWorking() {
		return timeWorking;
	}

	public void setTimeWorking(int timeWorking) {
		this.timeWorking = timeWorking;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}
	

	public TimeKeepingDetailEntity(long id, String timeStart, String timeEnd, int timeWorking, String shift, int status,
			TimeKeepingEntity timeKeeping) {
		super();
		Id = id;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.timeWorking = timeWorking;
		this.shift = shift;
		this.status = status;
		this.timeKeeping = timeKeeping;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public TimeKeepingEntity getTimeKeeping() {
		return timeKeeping;
	}

	public void setTimeKeeping(TimeKeepingEntity timeKeeping) {
		this.timeKeeping = timeKeeping;
	}

}
