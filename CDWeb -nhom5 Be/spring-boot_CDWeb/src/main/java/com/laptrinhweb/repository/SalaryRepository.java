package com.laptrinhweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.SalaryEntity;

public interface SalaryRepository extends JpaRepository<SalaryEntity, Long> {

}
