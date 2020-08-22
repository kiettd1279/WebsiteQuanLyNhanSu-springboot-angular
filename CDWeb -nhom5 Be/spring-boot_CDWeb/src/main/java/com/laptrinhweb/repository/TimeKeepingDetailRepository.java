package com.laptrinhweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.TimeKeepingDetailEntity;

public interface TimeKeepingDetailRepository extends JpaRepository<TimeKeepingDetailEntity , Long > {
	List<TimeKeepingDetailEntity> findByStatus(int status);
	List<TimeKeepingDetailEntity> findByShift(String shift);
	
	
}
