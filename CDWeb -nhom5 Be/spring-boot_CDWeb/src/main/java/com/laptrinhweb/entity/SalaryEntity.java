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
@Table(name = "salary")
public class SalaryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	@Column
	private String CountedDate;

	@Column
	private int WorkDay;

	@Column
	private int TaxMoney;

	@Column
	private int RewardMoney;

	@Column
	private int PublishMoney;

	@Column
	private int InsurranceMoney;

	@Column
	private double Salary;

	@Column
	private boolean IsActive;

	@ManyToOne
	@JoinColumn(name = "employeeID")
	private EmployeeEntity employee;
	
	public SalaryEntity() {
		super();
	}

	public SalaryEntity(String countedDate, int workDay, int taxMoney, int rewardMoney, int publishMoney,
			int insurranceMoney, double salary, boolean isActive) {
		super();
		CountedDate = countedDate;
		WorkDay = workDay;
		TaxMoney = taxMoney;
		RewardMoney = rewardMoney;
		PublishMoney = publishMoney;
		InsurranceMoney = insurranceMoney;
		Salary = salary;
		IsActive = isActive;
	}

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
