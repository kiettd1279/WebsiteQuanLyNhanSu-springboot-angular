package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.dto.CandidateDTO;
import com.laptrinhweb.entity.CandidateEntity;

public interface ICandidateService {
	List<CandidateDTO> findAll();
	CandidateDTO save(CandidateDTO dto) ;
}
