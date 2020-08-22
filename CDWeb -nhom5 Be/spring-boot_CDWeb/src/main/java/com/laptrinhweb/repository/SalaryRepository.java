package com.laptrinhweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.SalaryEntity;

public interface SalaryRepository extends JpaRepository<SalaryEntity, Long> {
	//List<SalaryEntity> findByIsActive( boolean active);
}
