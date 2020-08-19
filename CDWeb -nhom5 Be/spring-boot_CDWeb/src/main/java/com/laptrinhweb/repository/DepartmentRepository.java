package com.laptrinhweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.DeparmentEntity;

public interface DepartmentRepository extends JpaRepository<DeparmentEntity, Long> {

}
