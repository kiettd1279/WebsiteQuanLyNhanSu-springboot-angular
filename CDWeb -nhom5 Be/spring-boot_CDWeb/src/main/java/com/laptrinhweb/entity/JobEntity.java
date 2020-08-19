package com.laptrinhweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
public class JobEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "codeJob")
	private String code;
	
	@Column(name = "jobTitle")
	private String title;

	@Column(name = "minSalary")
	private Double minSalary;

	@Column(name = "maxSalary")
	private Double maxSalary;

	@OneToMany(mappedBy = "job")
	private List<JobHistoryEntity> jobHistorys = new ArrayList<JobHistoryEntity>();

	

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}

	public Double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public List<JobHistoryEntity> getJobHistorys() {
		return jobHistorys;
	}

	public void setJobHistorys(List<JobHistoryEntity> jobHistorys) {
		this.jobHistorys = jobHistorys;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	
	
}
