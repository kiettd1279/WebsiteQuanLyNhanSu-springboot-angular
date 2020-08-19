package com.laptrinhweb.dto;

import javax.persistence.Column;

public class SalaryDTO {
	private long Id;

	private String CountedDate;

	private int WorkDay;

	private int TaxMoney;

	private int RewardMoney;

	private int PublishMoney;

	private int InsurranceMoney;

	private double Salary;

	private boolean IsActive;

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

	public String getCountedDate() {
		return CountedDate;
	}

	public void setCountedDate(String countedDate) {
		CountedDate = countedDate;
	}

	public int getWorkDay() {
		return WorkDay;
	}

	public void setWorkDay(int workDay) {
		WorkDay = workDay;
	}

	public int getTaxMoney() {
		return TaxMoney;
	}

	public void setTaxMoney(int taxMoney) {
		TaxMoney = taxMoney;
	}

	public int getRewardMoney() {
		return RewardMoney;
	}

	public void setRewardMoney(int rewardMoney) {
		RewardMoney = rewardMoney;
	}

	public int getPublishMoney() {
		return PublishMoney;
	}

	public void setPublishMoney(int publishMoney) {
		PublishMoney = publishMoney;
	}

	public int getInsurranceMoney() {
		return InsurranceMoney;
	}

	public void setInsurranceMoney(int insurranceMoney) {
		InsurranceMoney = insurranceMoney;
	}

	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}

	public boolean isIsActive() {
		return IsActive;
	}

	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}

}
