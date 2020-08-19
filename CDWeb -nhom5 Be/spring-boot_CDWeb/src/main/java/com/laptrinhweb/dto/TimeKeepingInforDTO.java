package com.laptrinhweb.dto;

public class TimeKeepingInforDTO {
	private TimeKeepingDTO data;
	private boolean operation;

	public TimeKeepingDTO getData() {
		return data;
	}

	public void setData(TimeKeepingDTO data) {
		this.data = data;
	}

	public boolean getOperation() {
		return operation;
	}

	public void setOperation(boolean status) {
		this.operation = status;
	}

}
