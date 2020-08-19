package com.laptrinhweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.JobHistoryEntity;

public interface JobHistoryRepository extends JpaRepository<JobHistoryEntity, Long>{

}
