package com.laptrinhweb.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

public class EmployeeDTO {
	Long id;
	String firstName;
	String lastName;
	String email;
	String phoneNumber;
	int salary;
	List<JobHistoryDTO> listJH = new ArrayList<JobHistoryDTO>();
	boolean active;
	private String workingDay;
	private String identityCard;
	private String address;
	private String introduceBuddy;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getWorkingDay() {
		return workingDay;
	}

	public void setWorkingDay(String workingDay) {
		this.workingDay = workingDay;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIntroduceBuddy() {
		return introduceBuddy;
	}

	public void setIntroduceBuddy(String introduceBuddy) {
		this.introduceBuddy = introduceBuddy;
	}

	public List<JobHistoryDTO> getListJH() {
		return listJH;
	}

	public void setListJH(List<JobHistoryDTO> listJH) {
		this.listJH = listJH;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
