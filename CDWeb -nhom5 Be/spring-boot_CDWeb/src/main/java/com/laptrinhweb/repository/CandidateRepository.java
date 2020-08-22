package com.laptrinhweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.CandidateEntity;


public interface CandidateRepository  extends JpaRepository<CandidateEntity, Long> {
}
