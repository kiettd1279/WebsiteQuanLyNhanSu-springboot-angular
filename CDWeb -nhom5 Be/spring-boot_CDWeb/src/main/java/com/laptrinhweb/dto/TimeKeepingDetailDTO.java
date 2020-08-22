package com.laptrinhweb.dto;

public class TimeKeepingDetailDTO {
	public long Id;

	private String timeStart;
	private String timeEnd;

	private int timeWorking;

	private String shift;

	private int status;

	private TimeKeepingDTO timeKeeping;

	private EmployeeDTO employee;
	
	public EmployeeDTO getEmployee() {
		return employee;
	}
	
	public void setEmployee(EmployeeDTO employee) {
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public TimeKeepingDTO getTimeKeeping() {
		return timeKeeping;
	}

	public void setTimeKeeping(TimeKeepingDTO timeKeeping) {
		this.timeKeeping = timeKeeping;
	}

}
