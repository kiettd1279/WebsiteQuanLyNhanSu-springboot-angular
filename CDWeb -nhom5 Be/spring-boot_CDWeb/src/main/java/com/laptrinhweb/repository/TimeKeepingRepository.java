package com.laptrinhweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.TimeKeepingEntity;

public interface TimeKeepingRepository extends JpaRepository<TimeKeepingEntity, Long>  {
	List<TimeKeepingEntity> findByStatus(int status);
	List<TimeKeepingEntity> findByMorning(int morning);
	List<TimeKeepingEntity> findByAfternoon(int afternoon);
	
}
