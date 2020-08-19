package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.dto.DeparmentDTO;
import com.laptrinhweb.entity.DeparmentEntity;

public interface IDeparmentService {
	List<DeparmentDTO> findAll();
	DeparmentDTO save(DeparmentDTO dto);
}
