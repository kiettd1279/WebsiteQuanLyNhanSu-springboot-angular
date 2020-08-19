package com.laptrinhweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, Long> {
	JobEntity findOneByCode(String code);
}
