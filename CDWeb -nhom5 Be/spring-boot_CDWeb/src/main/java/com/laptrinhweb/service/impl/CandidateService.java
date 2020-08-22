package com.laptrinhweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhweb.conveter.CandidateConveter;
import com.laptrinhweb.dto.CandidateDTO;
import com.laptrinhweb.entity.CandidateEntity;
import com.laptrinhweb.repository.CandidateRepository;
import com.laptrinhweb.service.ICandidateService;

@Service
public class CandidateService implements ICandidateService {
	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private CandidateConveter candidateConverter;
	@Override
	public List<CandidateDTO> findAll() {
		List<CandidateEntity> listEntity = candidateRepository.findAll();
		List<CandidateDTO> listDTO = new ArrayList<CandidateDTO>();
		for (CandidateEntity item : listEntity) {
			CandidateDTO dto = candidateConverter.toDTO(item);
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public CandidateDTO save(CandidateDTO dto) {
		CandidateEntity entity;
		if (dto.getId() != null) {
			CandidateEntity oldEntity = candidateRepository.findOne(dto.getId());
			entity = candidateConverter.toEntity(oldEntity, dto);
		} else {
			entity = candidateConverter.toEntity(dto);
		}
	
		entity = candidateRepository.save(entity);
		return candidateConverter.toDTO(entity);
	
	}


}
